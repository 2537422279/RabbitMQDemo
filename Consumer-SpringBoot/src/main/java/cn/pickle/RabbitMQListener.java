package cn.pickle;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Pickle
 * @version V1.0
 * @date 2022/10/5 19:25
 */
@Component
public class RabbitMQListener {

    @RabbitListener(queues = "boot_queue")
    public void ListenerQueue(Message message){
        System.out.println(new String(message.getBody()));
    }
}
