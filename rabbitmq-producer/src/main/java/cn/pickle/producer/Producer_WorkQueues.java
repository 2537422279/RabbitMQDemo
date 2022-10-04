package cn.pickle.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Pickle
 * @version V1.0
 * @date 2022/10/3 17:36
 */
public class Producer_WorkQueues {
    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setPassword("pickle");
        factory.setUsername("pickle");
        factory.setPort(5672);
        factory.setHost("localhost");
        factory.setVirtualHost("/");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        //创建消息队列
        channel.queueDeclare("work_queues",true,false,false,null);
        for (int i = 1; i <= 10; i++) {
            String body = i + "hello rabbitmq~~~";
            channel.basicPublish("","work_queues",null,body.getBytes());
        }
    }
}
