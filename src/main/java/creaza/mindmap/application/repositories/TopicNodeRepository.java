package creaza.mindmap.application.repositories;

import creaza.mindmap.application.models.TopicNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicNodeRepository extends JpaRepository<TopicNode, Long> {
}
