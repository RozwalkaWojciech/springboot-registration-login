package javer.springbootregistrationlogin.repository;

import javer.springbootregistrationlogin.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {

        User user = User.builder()
                .email("test@gmail.com")
                .password("test")
                .firstName("testName")
                .lastName("testLastName")
                .build();

        User saveUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, saveUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindByEmail() {

        String email = "test@gmail.com";

        User user = userRepository.findByEmail(email);

        assertThat(user).isNotNull();
    }

    @Test
    public void testFindUserByEmail() {

        String email = "test@gmail.com";

        User user = userRepository.findUserByEmail(email);

        assertThat(user).isNotNull();
    }
}