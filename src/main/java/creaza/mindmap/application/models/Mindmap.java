package creaza.mindmap.application.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mindmap {

    //region FIELDS...

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private TopicNode mainNode;


    //endregion

    //region CONSTRUCTORS

    public Mindmap() {
    }

    public Mindmap(String title, String mainTopic, String subTopic, int numberOfSubNodes) {
        this.title = title;
        this.mainNode = new TopicNode(mainTopic, subTopic, numberOfSubNodes);
    }

    //endregion

    //region GETTERS

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TopicNode getMainNode() {
        return mainNode;
    }


    //endregion


    //region SETTERS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMainNode(TopicNode mainNode) {
        this.mainNode = mainNode;
    }

    //endregion

    //region OVERRIDES

    @Override
    public boolean equals(Object obj) {
        //TODO: Implement Method
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format( "Id: %s\nTitle: %s\nMainNode: %s\n", id,title, mainNode);
    }

    //endregion

}
