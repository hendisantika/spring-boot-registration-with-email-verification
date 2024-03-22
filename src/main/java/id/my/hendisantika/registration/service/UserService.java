package id.my.hendisantika.registration.service;

import id.my.hendisantika.registration.repository.ConfirmationTokenRepository;
import id.my.hendisantika.registration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-registration-with-email-verification
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/22/24
 * Time: 07:06
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final ConfirmationTokenRepository confirmationTokenRepository;

    private final EmailService emailService;
}
