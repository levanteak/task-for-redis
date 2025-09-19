package task.redis.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.redis.v1.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}
