package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.dto.PrzodownikDTO;
import grupa4.projektzespolowy.GOTTPKProjekt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${url.main.path}")
    private String path;
    private final JavaMailSender javaMailSender;
    private final PrzodownikService przodownikService;
    private final WycieczkaService wycieczkaService;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender, PrzodownikService przodownikService, WycieczkaService wycieczkaService) {
        this.javaMailSender = javaMailSender;
        this.przodownikService = przodownikService;
        this.wycieczkaService = wycieczkaService;
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

    @Override
    public void sendEmailAboutReportedBook(Ksiazeczka ksiazeczka) {
        this.sendEmail("notifi2020@outlook.com", "Zgłoszono książeczkę", "Turysta " + ksiazeczka.getTurysta().getImie() + " " + ksiazeczka.getTurysta().getNazwisko() +
                " zgłosił książeczkę do weryfikacji. <a href='"+ path + "/ksiazeczka/" + ksiazeczka.getIdKsiazeczka() +"'>PRZEJDŹ DO KSIĄŻECZKI</a>");
    }

    @Async
    @Override
    @Transactional
    public void sendEmailAboutReportedTour(Wycieczka w) throws InterruptedException {
        Wycieczka wycieczka = wycieczkaService.getOneById(w.getIdWycieczka());
        List<PrzodownikDTO> przodownikList = przodownikService.getAllPrzodownik();
        List<Trasa> trasyWycieczki = wycieczka.getTrasy();

        for(PrzodownikDTO przodownikDTO : przodownikList) {
            List<Grupa> grupyPrzodownika = przodownikDTO.getGrupy().stream().map(GrupaPrzodownik::getGrupa).collect(Collectors.toList());
            for(Trasa trasa : trasyWycieczki) {
                if(grupyPrzodownika.contains(trasa.getPasmo().getGrupa())) {

                    this.sendEmail(przodownikDTO.getUzytkownik().getEmail(), "Zgłoszono wycieczkę", "Turysta " + wycieczka.getKsiazeczka().getTurysta().getImie() + " " + wycieczka.getKsiazeczka().getTurysta().getNazwisko() +
                            " zgłosił książeczkę do weryfikacji. <a href='"+ path + "/zdjecia/" + wycieczka.getIdWycieczka() +"'>PRZEJDŹ DO WYCIECZKI</a>");
                    Thread.sleep(400);

                }
            }
        }
    }
}
