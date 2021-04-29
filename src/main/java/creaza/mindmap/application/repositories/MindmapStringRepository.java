package creaza.mindmap.application.repositories;

import creaza.mindmap.application.models.MindmapString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MindmapStringRepository extends JpaRepository<MindmapString, Long>
{
}
