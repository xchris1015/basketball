package io.chris.training.api.v1;

import com.amazonaws.services.sqs.model.MessageAttributeValue;
import io.chris.training.service.jms.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/{Id}",method = RequestMethod.POST)
    public Boolean findUserById(@PathVariable("Id") Long message){
        logger.debug("Message id is:" + message);
        messageService.sendMessage("Id",5);
        return true;
    }
}
