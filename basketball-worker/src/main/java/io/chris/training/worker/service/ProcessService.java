package io.chris.training.worker.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import sun.awt.SunHints;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProcessService {
    // TODO Fix that message sender and receiver on map object.
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @JmsListener(destination ="chrisbasketball-dev")
    public void processMessage(String message){
        ProcessService processService = new ProcessService();
        Map<String, Object> map = processService.convertStringToMap(message);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            logger.info("receive messageKey:" + key);
            logger.info("receive messageContent:" + value);
        }
    }


    public Map<String,Object> convertStringToMap(String string){
        Map<String, Object> map = null;
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
