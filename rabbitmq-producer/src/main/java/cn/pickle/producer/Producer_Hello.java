package cn.pickle.producer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @describe 发送消息
 * @author Pickle
 * @version V1.0
 * @date 2022/10/3 15:08
 */

public class Producer_Hello {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置参数,
        factory.setHost("localhost");       //IP地址
        factory.setPort(5672);              //端口，默认值5672
        factory.setVirtualHost("/");        //设置虚拟机，默认值"/"
        factory.setUsername("pickle");
        factory.setPassword("pickle");
        //创建连接
        final Connection connection = factory.newConnection();
        //创建channel
        final Channel channel = connection.createChannel();
        //创建消息队列
        /*
            queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments) throws IOException {
         */
        channel.queueDeclare("hello_world", true, false, false, null);
        //发送消息
        String body = "hello rabbitmq~~~~";
        channel.basicPublish("","hello_world",null,body.getBytes());

        //释放资源
        channel.close();
        connection.close();
    }
}
