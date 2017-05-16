package com.liu.mq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;
//消息监听器   
//@Component("consumerMessageListener")
public class MQConsumer implements MessageListener{

	@Override
	public void onMessage(Message message) {  
        //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
        TextMessage textMsg = (TextMessage) message;  
        System.out.println("接收到一个纯文本消息。");  
        try {  
            System.out.println("消息内容是：" + textMsg.getText());  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
    } 
	/*@Autowired
	JmsTemplate jmsTemplate;

	public String receiveMessage() {
		String my = "";
		MapMessage message = (MapMessage) jmsTemplate.receive();
		try {
			my = message.getString("lastName");
			System.out.println("收到了：" + my);
		} catch (JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}
		return my;
	}*/
}
