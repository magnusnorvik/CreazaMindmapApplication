package creaza.mindmap.application.controllers;

import creaza.mindmap.application.models.ProjectTemplate;
import creaza.mindmap.application.services.ProjectTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/projectTemplates")
public class ProjectTemplateController {

    @Autowired
    private ProjectTemplateService projectTemplateService;

    @GetMapping
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    public ResponseEntity<List<ProjectTemplate>> getAllTemplates()
    {
        List<ProjectTemplate> templates = projectTemplateService.getAll();
        return ResponseEntity.ok(templates);
    }
}
