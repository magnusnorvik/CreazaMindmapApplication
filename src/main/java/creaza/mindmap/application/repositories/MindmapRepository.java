package creaza.mindmap.application.repositories;

import creaza.mindmap.application.models.Mindmap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MindmapRepository extends JpaRepository<Mindmap, Long> {
}
