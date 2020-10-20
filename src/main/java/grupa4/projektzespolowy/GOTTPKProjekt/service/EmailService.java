package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;

public interface EmailService {

    void sendEmail(String to, String title, String content);

    void sendActivationLinkToNewUser(Uzytkownik user);

    void sendEmailAboutNewBadge(TurystaOdznaka turystaOdznaka);
}
