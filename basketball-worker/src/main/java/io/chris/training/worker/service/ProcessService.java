package io.chris.training.worker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProcessService {
    // TODO Fix that message sender and receiver on map object.
    protected final Logger logger = LoggerFactory.getLogger(getClass());

//    @JmsListener(destination ="chrisbasketball-dev")
//    public void processMessage(Map<String,Object> message){
//        String mesType = (String) message.get("msgType");
//        String mesText = (String) message.get("msgText");
//        Long userID = Long.valueOf(mesText);
//        logger.info("receive messageType:" + mesType);
//        logger.info("receive messageText:" + mesText);
//    }
//    }

    @JmsListener(destination ="chrisbasketball-dev")
    public void processMessage(String message){
        logger.info("this message is:"+message);
    }

}
