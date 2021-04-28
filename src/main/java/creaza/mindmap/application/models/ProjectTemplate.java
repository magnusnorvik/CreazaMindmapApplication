package creaza.mindmap.application.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

public class ProjectTemplate
{
    private int id;

    private String templateName;

    private String templateJSONString;

    public ProjectTemplate(int id, String templateName, String templateJSONString)
    {
        this.id = id;
        this.templateName = templateName;
        this.templateJSONString = templateJSONString;
    }

    public int getId()
    {
        return id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getTemplateJSONString() {
        return templateJSONString;
    }

    @Override
    public String toString() {
        return "ProjectTemplate{" +
                "id=" + id +
                ", templateName='" + templateName + '\'' +
                ", templateJSONString='" + templateJSONString + '\'' +
                '}';
    }
}

