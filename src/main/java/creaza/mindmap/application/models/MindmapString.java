package creaza.mindmap.application.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class MindmapString
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String filename;


    @NotNull
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String mindmapJSONString;


    public MindmapString()
    {
    }

    public MindmapString(String filename, String mindmapJSONString)
    {
        this.mindmapJSONString = mindmapJSONString;
    }


    public Long getId()
    {
        return id;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
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
