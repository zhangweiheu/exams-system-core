package com.online.exams.system.core.config;

import com.online.exams.system.core.listener.PaperListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class RabbitConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername("zhangwei");
        connectionFactory.setPassword("zhangwei");
        connectionFactory.setAddresses("192.168.1.115");
//        connectionFactory.setAddresses("45.32.47.210");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

     @Bean
     public RabbitTemplate rabbitTemplate() {
     return new RabbitTemplate(connectionFactory());
     }


    /***************************
     * 队列声明 START
     *********************/

    @Bean
    public Queue exams_online_system_paper_queue() {
        return new Queue("exams_online_system_paper_queue");
    }

    /*************************** 队列声明 END ***********************/

    /***************************
     * exchange声明 START
     *********************/
    @Bean
    public TopicExchange exams_online_system_paper_exchange() {
        return new TopicExchange("exams_online_system_paper_exchange");
    }


    /*************************** exchange声明 END ***********************/

    /***************************
     * 队列与exchange绑定 START
     *********************/
    @Bean
    public Binding b1() {
        return BindingBuilder.bind(exams_online_system_paper_queue()).to(exams_online_system_paper_exchange()).with("#");
    }

    /*************************** 队列与exchange绑定 END ***********************/

    /***************************
     * 消费线程池的控制 START
     *********************/
    private SimpleMessageListenerContainer commonContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(100);
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        container.setMissingQueuesFatal(false);
        return container;
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(200);
        threadPoolTaskExecutor.setThreadNamePrefix("Listener-Thread-");
        threadPoolTaskExecutor.setKeepAliveSeconds(600);
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return threadPoolTaskExecutor;
    }

    /*************************** 消费线程池的控制 END ***********************/


    /***************************
     * paper的消费 START
     *********************/
    @Bean
    public PaperListener paperListener() {
        return new PaperListener();
    }

    @Bean
    public SimpleMessageListenerContainer PaperListenerContainer() {
        SimpleMessageListenerContainer container = commonContainer();
        container.setQueues(exams_online_system_paper_queue());
        container.setMessageListener(paperListener());
        return container;
    }
    /*************************** paper的消费 END ***********************/


}
