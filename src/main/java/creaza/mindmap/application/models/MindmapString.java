package creaza.mindmap.application.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MindmapString
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String mindmapJSONString;

    public MindmapString()
    {
    }

    public MindmapString(String mindmapJSONString)
    {
        this.mindmapJSONString = mindmapJSONString;
    }

    public String getMindmapJSONString()
    {
        return mindmapJSONString;
    }

    public void setMindmapJSONString(String mindmapJSONString)
    {
        this.mindmapJSONString = mindmapJSONString;
    }

    @Override
    public String toString()
    {
        return "MindmapString{" +
                "id=" + id +
                ", mindmapJSONString='" + mindmapJSONString + '\'' +
                '}';
    }
}
