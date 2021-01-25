package creaza.mindmap.application.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class TopicNode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String topic;

    @OneToOne
    Mindmap mindmap;

    @ManyToOne
    @JoinColumn(name = "fk_parent_node_id") // This error will likely go away with a real database.
    private TopicNode parentNode;

    @OneToMany (
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "parentNode"
    )
    private List<TopicNode> subNodes;

    // ---------------------------------- CONSTRUCTORS----------------------------------------------//
    public TopicNode() {
    }

    public TopicNode(Mindmap mindmap, String topic) {
        this.topic = topic;
        this.mindmap = mindmap;
    }

    public TopicNode(String topic, String subTopic, int numberOfSubNodes) {
        this.topic = topic;
        addInitialSubNodes(numberOfSubNodes, subTopic);
    }

    // ------------------------------------ METHODS ------------------------------------------------//

    private void addInitialSubNodes(int numberOfNodes, String subTopic) {
        for (int i = 0; i < numberOfNodes; i++) {
            addSubNode(new TopicNode(mindmap, subTopic));
        }
    }

    public void addSubNode(TopicNode topicNode) {
        topicNode.parentNode = this;
        subNodes.add(topicNode);
    }

    // ------------------------------------ GETTERS ------------------------------------------------//

    public Long getId() {return id;}

    public String getTopic() {
        return topic;
    }

    public List<TopicNode> getSubNodes() {
        return subNodes;
    }

    // ------------------------------------ SETTERS ------------------------------------------------//

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setSubNodes(List<TopicNode> subNodes) {
        this.subNodes = subNodes;
    }

    // ----------------------------------- OVERRIDES -----------------------------------------------//

    @Override
    public boolean equals(Object obj) {
        //TODO: Implement Method
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format( "Id: %s\nName: %s\n", id, topic));
        stringBuilder.append(("Subnodes:\n"));
        for(TopicNode subNode : subNodes) {
            stringBuilder.append(String.format("%s", subNode));
        }
        return stringBuilder.toString();
    }

}
