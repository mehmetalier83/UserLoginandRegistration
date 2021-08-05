package business.concretes;

import business.abstracts.CustomerChecksService;
import business.abstracts.CustomerService;
import business.abstracts.VerificationService;
import dataAccess.abstracts.CustomerDao;
import entities.concretes.Customer;


public class CustomerManager implements CustomerService {
    CustomerDao customerDao;
    VerificationService mailVerificationService;
    CustomerChecksService customerChecksService;

    public CustomerManager(CustomerDao customerDao, VerificationService mailVerificationService, CustomerChecksService customerChecksService) {
        this.customerDao = customerDao;
        this.mailVerificationService = mailVerificationService;
        this.customerChecksService = customerChecksService;
    }

    @Override
    public void signUp(Customer customer) {
        //CustomerCheckManager'da bulunan isValid operasyonu tüm bilgiler doğru ise true oluyor.
        //Bu bilgilerin tümünün doğru olması durumunda email doğrulama mail'i gönderiliyor ve database ekleniyor.
        if (customerChecksService.isValid(customer)==true){
            System.out.println("Sisteme başarı ile eklenmiştir." + customer.getFirstName() + "" + customer.getLastName());
            mailVerificationService.sendMail(customer.getEmail());
            customerDao.add(customer);
        }
    }

    @Override
    public void signIn(Customer customer) {
    // Bu kodu çalıştırırsak doğrulama mailine tıklamış oluyoruz gibi düşünüyoruz.
    mailVerificationService.verifyMail(customer.getEmail());
    //Bu komutta isVerificated komutunu çağırarak buraya gönderilen kullanıcının mail adresinin doğrulanan mail'ler listesinde olup olmadığını kontrol ediyoruz.
    if (customerDao.getEmail(customer.getEmail())&&customerDao.getPassword(customer.getPassword())&&
            mailVerificationService.isVerificated(customer.getEmail())==true){
        System.out.println("Kullanıcı girişi başarıyla yapıldı.");
    }else if (mailVerificationService.isVerificated(customer.getEmail())){
        System.out.println("Kullanıcı bilgileri doğru. Fakat mail adresi doğrulanmadığı için giriş yapılamıyor.");
    }else{
        System.out.println("Kullanıcı bilgileri yanlış, lütfen kontrol ediniz");
    }
    }
}
