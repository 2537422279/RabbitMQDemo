package cn.pickle.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Pickle
 * @version V1.0
 * @date 2022/10/4 16:05
 */
public class Producer_PubSub {
    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("pickle");
        factory.setPassword("pickle");
        factory.setVirtualHost("/");

        final Connection connection = factory.newConnection();

        final Channel channel = connection.createChannel();

        //创建交换机
//        String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments
//        exchange:交换机名称
//        type:
        String exchangeName = "test_fanout";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT,true,false,false,null);

        //创建队列
        String queue1Name = "test_fanout_queue1";
        String queue2Name = "test_fanout_queue2";
        channel.queueDeclare(queue1Name,true,false,false,null);
        channel.queueDeclare(queue2Name,true,false,false,null);

        //绑定队列和交换机
        channel.queueBind(queue1Name,exchangeName,"");
        channel.queueBind(queue2Name,exchangeName,"");

        //发送消息
        String body = "日志信息：张三调用了fanout方法.... 日志级别：info...";
        channel.basicPublish(exchangeName,"",null,body.getBytes());

        channel.close();
        connection.close();
    }
}
