package cn.pickle.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Pickle
 * @version V1.0
 * @date 2022/10/4 17:26
 */
public class Consumer_Routing1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setPort(5672);
        factory.setPassword("pickle");
        factory.setUsername("pickle");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        String queue1Name = "test_direct_queue1";
        String queue2Name = "test_direct_queue2";
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body: " + new String(body));
                System.out.println("将日志信息打印到控制台....");
            }
        };
        channel.basicConsume(queue2Name,true,consumer);
    }
}
