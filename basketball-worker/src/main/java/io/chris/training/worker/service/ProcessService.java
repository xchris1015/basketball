package io.chris.training.worker.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.MessageCreator;
import io.chris.training.core.domain.User;
import io.chris.training.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@EnableAutoConfiguration
public class ProcessService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public UserService userService;


    @JmsListener(destination ="chrisbasketball-dev")
    public void processMessage(String message){

        Map<Object, Object> map = convertStringToMap(message);
        String messageBody = (String) map.get("messageKey");
        Long id = Long.valueOf((String) map.get("object_id")).longValue();
        User user = userService.findById(id);
        String phoneNumber = user.getPhoneNumber();

        String sendNumber = "+12025177959";

        MessageCreator messageCreator = SMS(phoneNumber,"body",sendNumber);
        twillioSMSSend(messageCreator);
        logger.info("receive messageContent:" + messageBody);
        logger.info("Object Id:" + id);

    }

    public MessageCreator SMS(String receiveNumber,String messageBody, String sendNumber) {
        MessageCreator message = Message.creator(
                new com.twilio.type.PhoneNumber(receiveNumber),
                new com.twilio.type.PhoneNumber("+12025177959"),
                messageBody);
        return message;
    }

    public void twillioSMSSend(MessageCreator creator){
        creator.create();
    }

    public Map<Object,Object> convertStringToMap(String string){
        Map<Object, Object> map = null;
        ObjectMapper mapper = new ObjectMapper();
        // convert JSON string to Map
        try {
            map = mapper.readValue(string, new TypeReference<Map<String, String>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}

