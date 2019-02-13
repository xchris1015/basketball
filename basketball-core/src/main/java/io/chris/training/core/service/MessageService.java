package io.chris.training.core.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private AmazonSQS sqs;
//    @Value("#{applicationProperties['jms.queue.name']}") // approach 2, insert to method argument with variable
//    private String queue="chrisbasketball-dev";
    private String queueUrl;

//    @Value("${jms.queue.name}")
//    private String queue;


    public MessageService(@Autowired AmazonSQS sqs,@Value("#{applicationProperties['jms.queue.name']}") String queue) {
        this.sqs = sqs;
        this.queueUrl = getQueueUrl(queue);
    }

    public AmazonSQS getSqs() {
        return sqs;
    }

    public void setSqs(AmazonSQS sqs) {
        this.sqs = sqs;
    }

//    public String getQueue() {
//        return queue;
//    }
//
//    public void setQueue(String queue) {
//        this.queue = queue;
//    }

    public void sendMessage(String messageBody,Integer delaySecond){
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(messageBody)
                .withDelaySeconds(delaySecond);
        sqs.sendMessage(send_msg_request);
    }


//    public void sendMessage(Map<String, MessageAttributeValue> messageBody, Integer delaySecond){
//        SendMessageRequest send_msg_request = new SendMessageRequest()
//                .withQueueUrl(queueUrl)
//                .withMessageBody("This is my message text.")
//                .withMessageAttributes(messageBody)
//                .withDelaySeconds(delaySecond);
//        sqs.sendMessage(send_msg_request);
//    }

    public void receiveMessage(AmazonSQS sqs,String queueUrl){
        List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
    }

    public String getQueueUrl(String queue){
        GetQueueUrlResult result = sqs.getQueueUrl(queue);
        String queue_url = result.getQueueUrl();
        return queue_url;
    }





}
