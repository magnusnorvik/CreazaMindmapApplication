package creaza.mindmap.application.controllers;

import creaza.mindmap.application.models.MindmapString;
import creaza.mindmap.application.services.MindmapStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/mindmapsJSON")
public class MindmapStringController
{
    @Autowired
    private MindmapStringService mindmapStringService;

    @GetMapping
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    public ResponseEntity<List<MindmapString>> getAllMindmaps() {
        List<MindmapString> mindmaps = mindmapStringService.getAll();
        return ResponseEntity.ok(mindmaps);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    public ResponseEntity<MindmapString> getMindmapById(@PathVariable Long id)
    {
        MindmapString mindmap = mindmapStringService.getById(id);

        if (mindmap != null)
            return ResponseEntity.ok(mindmap);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    public ResponseEntity<MindmapString> save(@RequestBody MindmapString mindmapStringData) {
        // TODO: Validate request body
        return new ResponseEntity<>(mindmapStringService.createNew(mindmapStringData), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    public ResponseEntity<MindmapString> updateById(@RequestBody MindmapString mindmapStringData, @PathVariable Long id) {
        // TODO: Validate request body
        MindmapString updatedMindmap = mindmapStringService.update(mindmapStringData, id);

        if (updatedMindmap != null)
            return ResponseEntity.ok(mindmapStringService.update(mindmapStringData, id));

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    public void deleteMindmapById(@PathVariable Long id) {
        mindmapStringService.deleteById(id);
    }
}
