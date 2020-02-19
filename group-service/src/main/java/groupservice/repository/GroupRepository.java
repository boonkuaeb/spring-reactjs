package groupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import groupservice.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
