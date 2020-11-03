package grupa4.projektzespolowy.GOTTPKProjekt.service;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Ksiazeczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;

public interface EmailService {

    void sendEmail(String to, String title, String content);

    void sendActivationLinkToNewUser(Uzytkownik user);

    void sendEmailAboutNewBadge(TurystaOdznaka turystaOdznaka);

    void sendEmailAboutReportedBook(Ksiazeczka ksiazeczka);

    void sendEmailAboutReportedTour(Wycieczka wycieczka) throws InterruptedException;
}
