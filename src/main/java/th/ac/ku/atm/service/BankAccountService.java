package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {
    private List<BankAccount> bankAccountList;

    @PostConstruct
    public void postBankAccount(){
        this.bankAccountList = new ArrayList<>();
    }

    public List<BankAccount> getBankAccount(){
        return new ArrayList<>(this.bankAccountList);
    }

    public BankAccount findBankAccount(int id) {
        for (BankAccount bankAccount:bankAccountList){
            if (bankAccount.getId() == id)
                return bankAccount;
        }
        return null;
    }


    public void createBankaccount(BankAccount bankAccount) {
    }
}
