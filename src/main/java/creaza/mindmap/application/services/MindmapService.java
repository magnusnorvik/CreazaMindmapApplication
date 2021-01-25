package creaza.mindmap.application.services;

import creaza.mindmap.application.models.Mindmap;
import creaza.mindmap.application.repositories.MindmapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MindmapService {

    @Autowired
    private MindmapRepository mindmapRepository;

    public List<Mindmap> getAll() {
        return mindmapRepository.findAll();
    }

    public Mindmap getById(Long id) {
        return mindmapRepository.findById(id).orElse(null);
    }

    public Mindmap createNew(Mindmap mindmapRequestData, int numberOfSubNodes) {
        //TODO: Validate here?
        Mindmap mindmap = new Mindmap(mindmapRequestData.getTitle(), "Main Node", "1st lvl sub node", numberOfSubNodes);
        return mindmapRepository.save(mindmap);
    }

    public Mindmap update(Mindmap mindmapRequestData, Long id) {
        Mindmap updatedMindmap = mindmapRepository.findById(id)
                .map(mindmap -> {
                    mindmap.setTitle(mindmapRequestData.getTitle());
                    mindmap.setMainNode(mindmapRequestData.getMainNode());
                    mindmapRepository.save(mindmap);
                    return mindmap;
                })
                .orElse(null);
        return updatedMindmap;
    }

    public void deleteById(Long id) {
        //TODO: return status some how
        mindmapRepository.deleteById(id);
    }
}
