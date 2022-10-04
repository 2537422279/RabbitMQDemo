package cn.pickle.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Pickle
 * @version V1.0
 * @date 2022/10/4 16:25
 */
public class Consumer_PubSub2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setVirtualHost("/");
        factory.setPort(5672);
        factory.setUsername("pickle");
        factory.setPassword("pickle");

        final Connection connection = factory.newConnection();

        final Channel channel = connection.createChannel();

        String queue1Name = "test_fanout_queue1";
        String queue2Name = "test_fanout_queue2";

        final Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body: " + new String(body));
                System.out.println("将日志信息保存数据库....");
            }
        };

        channel.basicConsume(queue2Name,true,consumer);
    }
}
