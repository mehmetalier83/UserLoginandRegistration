package business.concretes;

import business.abstracts.CustomerChecksService;
import business.abstracts.VerificationService;

import java.util.ArrayList;
import java.util.List;

public class MailVerificationService implements VerificationService {
    CustomerChecksService customerChecksService;
    List<String> listofEmail=new ArrayList<String>();

    @Override
    public void sendMail(String email) {
        System.out.println(email + " kullanýcýsýna doðrulama mail'i gönderildi.");
    }

    @Override
    public void verifyMail(String email) {
    listofEmail.add(email);
    }

    @Override
    public boolean isVerificated(String email) {
        if (listofEmail.contains(email)){
            return true;
        }
    return false;
    }
}
