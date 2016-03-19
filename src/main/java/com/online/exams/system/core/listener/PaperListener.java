package com.online.exams.system.core.listener;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class PaperListener implements ChannelAwareMessageListener {
    private static Logger LOGGER = LoggerFactory.getLogger(PaperListener.class);
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);


    @Override
    public void onMessage(final Message message, Channel channel) throws Exception {
        final JSONObject receiveJsonMsg = JSONObject.parseObject(new String(message.getBody()));
        LOGGER.info("MailListener-consumer-receiveJsonMsg:{}", receiveJsonMsg);
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
