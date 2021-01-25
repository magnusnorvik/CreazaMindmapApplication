package creaza.mindmap.application.services;

import creaza.mindmap.application.models.TopicNode;
import creaza.mindmap.application.repositories.TopicNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TopicNodeService {

    @Autowired
    TopicNodeRepository topicNodeRepository;

    public TopicNode getById(Long id) {
        return topicNodeRepository.findById(id).orElse(null);
    }

    public TopicNode update(TopicNode topicNodeRequest, Long id) {
        TopicNode updatedTopicNode = topicNodeRepository.findById(id)
                .map(topicNode -> {
                    topicNode.setTopic(topicNodeRequest.getTopic());
                    for(TopicNode subNode : topicNodeRequest.getSubNodes()) {
                        topicNode.addSubNode(subNode);
                    }
                    topicNodeRepository.save(topicNode);
                    return topicNode;
                })
                .orElse(null);

        return updatedTopicNode;
    }

    public void deleteById(@PathVariable Long id) {
        //TODO: return status some how
        topicNodeRepository.deleteById(id);
    }
}
