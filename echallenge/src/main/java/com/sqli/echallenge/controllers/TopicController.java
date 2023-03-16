package com.sqli.echallenge.controllers;

import java.util.List;
import com.sqli.echallenge.models.Topic;
import com.sqli.echallenge.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class TopicController {

    @Autowired
    TopicService topicService;
    final Logger logger = LoggerFactory.getLogger(TopicController.class);

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        logger.debug("I am in getAllTopics");
        return topicService.getAllTopics();
    }


    @RequestMapping("/topics/{id}")
    public Topic getTopics(@PathVariable long id) {
        return topicService.getTopic(id).get();
    }

    @RequestMapping(method = RequestMethod.POST, value ="/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable long id) {
        logger.debug("I am in updateTopic");
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/topics/{id}")
    public void deleteTopic(@PathVariable long id) {
        topicService.deleteTopic(id);
    }

}

