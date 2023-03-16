package com.sqli.echallenge.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sqli.echallenge.dao.TopicRepository;
import com.sqli.echallenge.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(long id) {
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(long id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(long id) {
        Topic topic = getTopic(id).get();
        topicRepository.delete(topic);
    }


	/*public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i < topics.size(); i++) {

			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				System.out.println("ID is -> " + t.getId());
				topics.set(i, topic);
				return;
			}
		}

	}
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));

	}*/

}
