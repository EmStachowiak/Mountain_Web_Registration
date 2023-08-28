package pl.maja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maja.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByNickName(String nickName);
}
