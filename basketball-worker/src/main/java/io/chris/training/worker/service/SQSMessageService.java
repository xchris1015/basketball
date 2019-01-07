package io.chris.training.worker.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//@Service
//public class SQSMessageService {

//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private AmazonSQS sqs;
//
//    @Value("${jms.queue.name}")
//    private String queue;
//
//    public void receiveMessage(){
//        logger.debug("Receiving messages from MyQueue.\n");
//        final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(getQueueUrl(queue));
//        final List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
//        for (final Message message : messages) {
//            logger.debug("Message");
//            logger.debug("  MessageId:     " + message.getMessageId());
//            logger.debug("  ReceiptHandle: " + message.getReceiptHandle());
//            logger.debug("  MD5OfBody:     " + message.getMD5OfBody());
//            logger.debug("  Body:          " + message.getBody());
//            for (final Map.Entry<String, String> entry : message.getAttributes().entrySet()) {
//                logger.debug("Attribute");
//                logger.debug("  Name:  " + entry.getKey());
//                logger.debug("  Value: " + entry.getValue());
//            }
//        }
//    }
//
//    public String getQueueUrl(String queue){
//        GetQueueUrlResult result = sqs.getQueueUrl(queue);
//        String queue_url = result.getQueueUrl();
//        return queue_url;
//    }
//}
