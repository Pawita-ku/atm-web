package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    ///// private List<Customer> customers=new ArrayList<>();
    private BankAccountService bankaccountService;

    //@RequestMapping("/customer")
    public BankAccountController(BankAccountService bankaccountService)  {
        this.bankaccountService = bankaccountService;
    }

    @GetMapping/////("/customer")
    public String getBankAccountPage(Model model){
        model.addAttribute("allBankAccounts",bankaccountService.getBankAccounts());
        return "bankaccount"; //customer.html template
    }


    @PostMapping//////("/customer")
    public String registerBankAccount(@ModelAttribute BankAccount bankaccount, Model model) {
        bankaccountService.createBankAccount(bankaccount);
        model.addAttribute("allBankAccounts",bankaccountService.getBankAccounts());
        return "redirect:bankaccount";
    }

}
