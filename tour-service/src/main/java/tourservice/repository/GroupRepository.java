package tourservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tourservice.model.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
