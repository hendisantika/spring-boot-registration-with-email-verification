package id.my.hendisantika.registration.service;

import id.my.hendisantika.registration.entity.ConfirmationToken;
import id.my.hendisantika.registration.entity.User;
import id.my.hendisantika.registration.repository.ConfirmationTokenRepository;
import id.my.hendisantika.registration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final ConfirmationTokenRepository confirmationTokenRepository;

    private final EmailService emailService;

    @Transactional
    public ResponseEntity<?> saveUser(User user) {

        if (userRepository.existsByUserEmail(user.getUserEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        userRepository.save(user);

        ConfirmationToken confirmationToken = new ConfirmationToken(user);

        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getUserEmail());
        mailMessage.setFrom("Testing <no-reply@jvm.my.id>");
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8085/users/confirm-account?token=" + confirmationToken.getConfirmationToken());
        emailService.sendEmail(mailMessage);

        log.info("Confirmation Token: " + confirmationToken.getConfirmationToken());

        return ResponseEntity.ok("Verify email by the link sent on your email address");
    }

    public ResponseEntity<?> confirmEmail(String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = userRepository.findByUserEmailIgnoreCase(token.getUserEntity().getUserEmail());
            user.setEnabled(true);
            userRepository.save(user);
            return ResponseEntity.ok("Email verified successfully!");
        }
        return ResponseEntity.badRequest().body("Error: Couldn't verify email");
    }
}
