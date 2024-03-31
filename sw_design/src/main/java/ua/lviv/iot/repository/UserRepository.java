package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}