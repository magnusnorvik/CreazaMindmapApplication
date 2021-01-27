package creaza.mindmap.application.controllers;

import creaza.mindmap.application.models.TopicNode;
import creaza.mindmap.application.services.TopicNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/topicnodes")
public class TopicNodeController {

    @Autowired
    private TopicNodeService topicNodeService;


    @GetMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<TopicNode> getTopicById(@PathVariable Long id) {
        return ResponseEntity.ok(topicNodeService.getById(id));
    }

    @PutMapping
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<TopicNode> save(@RequestBody TopicNode topicNodeRequest) {
        // TODO: Validate request body
        System.out.println(topicNodeRequest);
        return ResponseEntity.ok(topicNodeService.update(topicNodeRequest, topicNodeRequest.getId()));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public void deleteById(@PathVariable Long id) {
        topicNodeService.deleteById(id);
    }

}
