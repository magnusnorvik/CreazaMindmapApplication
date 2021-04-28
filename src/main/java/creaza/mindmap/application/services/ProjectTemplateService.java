package creaza.mindmap.application.services;

import creaza.mindmap.application.models.Mindmap;
import creaza.mindmap.application.models.ProjectTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectTemplateService {

    public List<ProjectTemplate> getAll() {

        List<ProjectTemplate> templates = new ArrayList<>();
        templates.add(generateBlankTemplate());
        templates.add(generate4SubNodeTemplate());

        return templates;
    }

    private ProjectTemplate generateBlankTemplate() {
        return new ProjectTemplate(
                1,
                "Blank",
                "{\"id\":\"1\",\"title\":\"untitled!\",\"mainNode\":{\"id\":\"DB MAIN\",\"text\":\"Main topic (blank)\",\"x\":500,\"y\":400,\"nodeWidth\":300,\"nodeHeight\":100,\"layout\":\"mindmap\",\"children\":[]}}"
        );
    }

    private ProjectTemplate generate4SubNodeTemplate() {
        return new ProjectTemplate(
                2,
                "Basic",
                "{\"id\":\"2\",\"title\":\"untitled!\",\"mainNode\":{\"id\":\"DB MAIN\",\"text\":\"Main topic (basic)\",\"x\":500,\"y\":400,\"nodeWidth\":300,\"nodeHeight\":100,\"layout\":\"mindmap\",\"children\":[{\"id\":\"DB SUB 1\",\"text\":\"DB SUB 1\",\"x\":200,\"y\":200,\"nodeWidth\":200,\"nodeHeight\":100,\"layout\":\"mindmap\",\"children\":[]},{\"id\":\"DB SUB 2\",\"text\":\"DB SUB 2\",\"x\":900,\"y\":200,\"nodeWidth\":200,\"nodeHeight\":80,\"layout\":\"mindmap\",\"children\":[]},{\"id\":\"DB SUB 3\",\"text\":\"DB SUB 3\",\"x\":200,\"y\":600,\"nodeWidth\":200,\"nodeHeight\":80,\"layout\":\"mindmap\",\"children\":[]},{\"id\":\"DB SUB 4\",\"text\":\"DB SUB 4\",\"x\":900,\"y\":600,\"nodeWidth\":200,\"nodeHeight\":80,\"layout\":\"mindmap\",\"children\":[]}]}}"
        );
    }

}
