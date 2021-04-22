package creaza.mindmap.application.controllers;

import creaza.mindmap.application.models.Mindmap;
import creaza.mindmap.application.services.MindmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/mindmaps")
public class MindmapController {

    @Autowired
    MindmapService mindmapService;

    @GetMapping
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<List<Mindmap>> getAllMindmaps()
    {
        List<Mindmap> mindmaps = mindmapService.getAll();
        return ResponseEntity.ok(mindmaps);
    }

    @GetMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Mindmap> getMindmapById(@PathVariable Long id)
    {
        return ResponseEntity.ok(mindmapService.getById(id));
    }

    @PostMapping
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Mindmap> save(@RequestBody Mindmap mindmapData, @RequestParam int numberOfSubNodes)
    {
        // TODO: Validate request body
        return new ResponseEntity<>(mindmapService.createNew(mindmapData, numberOfSubNodes), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Mindmap> updateById(@RequestBody Mindmap mindmapRequest, @PathVariable Long id)
    {
        // TODO: Validate request body
        Mindmap updatedMindmap = mindmapService.update(mindmapRequest, id);

        if (updatedMindmap != null)
            return ResponseEntity.ok(mindmapService.update(mindmapRequest, id));
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public void deleteMindmapById(@PathVariable Long id)
    {
        //TODO: Implement "flag as deleted"
        mindmapService.deleteById(id);
    }

}
