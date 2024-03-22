package id.my.hendisantika.registration.repository;

import id.my.hendisantika.registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-registration-with-email-verification
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/22/24
 * Time: 07:02
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmailIgnoreCase(String emailId);

    Boolean existsByUserEmail(String email);
}
