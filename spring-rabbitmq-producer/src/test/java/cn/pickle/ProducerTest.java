package cn.pickle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Pickle
 * @version V1.0
 * @date 2022/10/4 20:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testHelloWorld(){
        //发送发送消息
        rabbitTemplate.convertAndSend("spring_queue","Hello spring world!");
    }
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("spring_fanout_exchange","","spring fanout...");
    }
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("spring_topic_exchange","heima.hehe.haha","spring topic...");
    }

}
