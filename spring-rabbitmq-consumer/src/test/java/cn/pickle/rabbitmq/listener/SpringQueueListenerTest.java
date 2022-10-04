package cn.pickle.rabbitmq.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Pickle
 * @version V1.0
 * @date 2022/10/4 21:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-consumer.xml")
public class SpringQueueListenerTest {
    @Test
    public void test1(){
        boolean flag = true;
        while(flag){

        }
    }
}
