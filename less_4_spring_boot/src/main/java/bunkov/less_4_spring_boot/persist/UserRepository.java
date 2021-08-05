package bunkov.less_4_spring_boot.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {


    @PersistenceContext
    private EntityManager em;

    // Identity Map
    private Map<Long, User> userMap = new ConcurrentHashMap<>();

    private AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new User("user1"));
        this.insert(new User("user2"));
        this.insert(new User("user3"));
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public User findById(long id) {
        return userMap.get(id);
    }

    public void insert(User user) {
        long id = identity.incrementAndGet();
        user.setId(id);
        userMap.put(id, user);
    }

    public void update(User user) {
        userMap.put(user.getId(), user);
    }

    public void delete(long id) {
        userMap.remove(id);
    }

}
