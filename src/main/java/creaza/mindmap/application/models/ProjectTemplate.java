package creaza.mindmap.application.models;


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

    public String getTemplateName()
    {
        return templateName;
    }

    public String getTemplateJSONString()
    {
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

