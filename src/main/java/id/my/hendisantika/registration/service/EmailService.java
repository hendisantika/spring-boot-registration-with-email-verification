package id.my.hendisantika.registration.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-registration-with-email-verification
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/22/24
 * Time: 07:05
 * To change this template use File | Settings | File Templates.
 */
@Service("emailService")
public class EmailService {

    private JavaMailSender javaMailSender;
}
