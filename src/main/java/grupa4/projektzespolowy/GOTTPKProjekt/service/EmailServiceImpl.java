package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${url.main.path}")
    private String path;
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    @Override
    public void sendEmail(String to, String title, String content) {

        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo("notifi2020@outlook.com");
            helper.setFrom("notifi2020@outlook.com");
            helper.setSubject(title);
            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }

    @Override
    public void sendActivationLinkToNewUser(Uzytkownik user) {
        this.sendEmail(user.getEmail(), "Aktywacja konta", "<strong>Dzień dobry " + user.getLogin() + "!</strong><br>" +
                "Kliknij w link, aby aktywować konto w naszej aplikacji GOT PTTK: <a href='" + path + "/aktywacja/" + user.getUUID() + "'>" + "AKTYWACJA KONTA" + "</a>");
    }

    @Override
    public void sendEmailAboutNewBadge(TurystaOdznaka turystaOdznaka) {
        this.sendEmail(turystaOdznaka.getTurysta().getUzytkownik().getEmail(), "Zdobyłeś nową odznakę", "<strong>Dzień dobry " + turystaOdznaka.getTurysta().getUzytkownik().getLogin() + "!</strong><br>" +
                "Otrzymałeś nową odznakę! " + turystaOdznaka.getOdznaka().getNazwa());
    }
}
