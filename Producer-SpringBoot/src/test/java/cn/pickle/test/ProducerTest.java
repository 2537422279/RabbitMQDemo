package cn.pickle.test;

import cn.pickle.rabbit.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Pickle
 * @version V1.0
 * @date 2022/10/5 0:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,"boot.haha","boot mq hello!");
    }
}
