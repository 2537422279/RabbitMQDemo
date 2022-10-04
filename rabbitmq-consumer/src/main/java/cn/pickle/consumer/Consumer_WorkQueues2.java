package cn.pickle.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Pickle
 * @version V1.0
 * @date 2022/10/3 17:47
 */
public class Consumer_WorkQueues2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPassword("pickle");
        factory.setUsername("pickle");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        Consumer comsurmer = new DefaultConsumer(channel){
            /*
                回调方法，当收到消息后自动执行该方法。
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println("consumerTag: " + consumerTag);
//                System.out.println("Exchange: " + envelope.getExchange());
//                System.out.println("RoutingKey: " + envelope.getRoutingKey());
//                System.out.println("Properties: " + properties);
                System.out.println("body: " + new String(body));
            }
        };
        channel.basicConsume("work_queues",true,comsurmer);
    }
}
