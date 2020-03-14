package com.aerors.ocs.mq;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


//点对点 消费者
@Component("queueReceiver")
public class QueueReceiver implements MessageListener{


	@Override
	public void onMessage(Message message) {
		try {

			System.out.println("QueueReceiver接收到消息:"+((TextMessage)message).getText());
			//手动向broker确认接收成功，如果发生异常，就不反回ack
			message.acknowledge();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
