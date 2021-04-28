package creaza.mindmap.application.services;

import creaza.mindmap.application.models.MindmapString;
import creaza.mindmap.application.repositories.MindmapStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MindmapStringService
{
    @Autowired
    private MindmapStringRepository mindmapStringRepository;


    public List<MindmapString> getAll()
    {
        return mindmapStringRepository.findAll();
    }

    public MindmapString getById(Long id) {
        return mindmapStringRepository.findById(id).orElse(null);
    }

    public MindmapString createNew(MindmapString mindmapStringData)
    {
        //MindmapString mindmapString = new MindmapString(mindmapStringData.getFilename(), mindmapStringData.getMindmapJSONString());
        return mindmapStringRepository.save(mindmapStringData);
    }

    public MindmapString update(MindmapString mindmapStringData, Long id)
    {
        return mindmapStringRepository.findById(id)
                .map(mindmap -> {
                    mindmap.setMindmapJSONString(mindmapStringData.getMindmapJSONString());
                    mindmapStringRepository.save(mindmap);
                    return mindmap;
                })
                .orElse(null);
    }

    public void deleteById(Long id)
    {
        //TODO: Flag as deleted implementation
        mindmapStringRepository.deleteById(id);
    }

}
