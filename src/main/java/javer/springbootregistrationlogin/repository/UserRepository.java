package javer.springbootregistrationlogin.repository;

import javer.springbootregistrationlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
