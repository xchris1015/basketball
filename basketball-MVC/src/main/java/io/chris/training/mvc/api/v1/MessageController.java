package io.chris.training.mvc.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.chris.training.core.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageService messageService;

    @RequestMapping(params={"messageBody","messageKey","id"},method = RequestMethod.POST)
    public boolean sendMessage(@RequestParam(value = "messageBody") String messageBody,@RequestParam(value = "messageKey") String messageKey,@RequestParam(value = "id")Long id){
        logger.debug("Message Body is:" + messageBody);
        logger.debug("Message Body is:" + messageKey);
        logger.debug("User Id is:" +id);
        Map<String,Object> map = convertStringToMap(messageKey,messageBody);
        map.put("object_id",id);
        String jsonString = convertMapToString(map);
        messageService.sendMessage(jsonString,5);
        return true;
    }

    private Map<String,Object> convertStringToMap(String messageKey,String messageBody){
        Map<String, Object> map = new HashMap<>();
        map.put(messageKey,messageBody);
        return map;
    }

    private String convertMapToString(Map<String,Object> map){
        String jsonString= null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            // convert map to JSON string
            jsonString = mapper.writeValueAsString(map);
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }


}
