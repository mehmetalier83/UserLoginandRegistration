package business.concretes;

import business.abstracts.CustomerChecksService;
import entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerCheckManager implements CustomerChecksService {
    //Aynı mail adresiyle kayıt olmayı engellemek için başarıyla kayıt olan üyelerin mail'lerini bu diziye saklıyoruz.
    //Daha sonra üyelik işlemi yapmaya çalışan olursa buradaki liste ile karşılaştırıyoruz.
    List<String > listofEmail=new ArrayList<String>();

    @Override
    public boolean checkFirstName(Customer customer) {
        if (customer.getFirstName().isEmpty()){
            System.out.println("İSİM BOŞ BIRAKILAMAZ");
            return false;
        }else{
            if (customer.getFirstName().length()<= 2){
                System.out.println("İsim 2 karakterden daha küçük olamaz.");
                return false;
            }
        }
    return true;
    }

    @Override
    public boolean checkLastName(Customer customer) {
        if (customer.getLastName().isEmpty()){
            System.out.println("İSİM BOŞ BIRAKILAMAZ");
            return false;
        }else{
            if (customer.getLastName().length()<= 2){
                System.out.println("İsim 2 karakterden daha küçük olamaz.");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkEmail(Customer customer) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        if (customer.getEmail().isEmpty()){
            System.out.println("Email girmek zorunludur");
            return false;
        }else {
            if (pattern.matcher(customer.getEmail()).find() == false) {
                System.out.println("Girilen email adresi formata uygun değil. Örnek: ornek@ornek.com");
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean checkPassword(Customer customer) {
        if (customer.getPassword().isEmpty()){
            System.out.println("Şifrenizi girmek zorundasınız");
            return false;
        }else{
            if(customer.getPassword().length() < 6){
                System.out.println("Şifreniz en az 6 haneden oluşmalıdır.");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean uniqueEmail(Customer customer) {
        boolean result=true;
        if (listofEmail.contains(customer.getEmail())){
            System.out.println("Bu mail adresi ile sisteme daha önce kayıt olunmuş, farklı bir mail adresi deneyiniz.");
            result =false;
        }else{
        result=true;
            listofEmail.add(customer.getEmail());
            System.out.println("Mail kaydedildi");
        }
        return result;
    }

    @Override
    public boolean isValid(Customer customer) {
        if (checkFirstName(customer) && checkLastName(customer) && checkEmail(customer) && checkPassword(customer)
                && uniqueEmail(customer) == true) {
            return true;
        }
        return false;
    }
}
