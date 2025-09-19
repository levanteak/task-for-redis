package task.redis.v1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import task.redis.v1.entity.User;
import task.redis.v1.repository.UserRepository;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // Создание пользователя (сразу кладём в кэш)
    @CachePut(value = "users", key = "#result.id")
    public User createUser(User user) {
        log.info("📌 Создаём нового пользователя и кладём в кэш...");
        return repo.save(user);
    }

    @Cacheable(value = "users", key = "#id")
    public Optional<User> getUser(Long id) {
        log.info("📌 Читаем из БД...");
        return repo.findById(id);
    }

    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        log.info("📌 Обновляем БД и кэш...");
        return repo.save(user);
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {
        log.info("📌 Удаляем из БД и кэша...");
        repo.deleteById(id);
    }
}
