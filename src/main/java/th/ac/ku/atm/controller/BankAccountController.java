package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class BankAccountController {

    ///// private List<Customer> customers=new ArrayList<>();
    private BankAccountService bankAccountService;

    //@RequestMapping("/customer")
    public BankAccountController(CustomerService customerService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping/////("/bankaccount")
    public String getBankAccountPage(Model model) {
        model.addAttribute("allBankaccount", bankAccountService.getBankAccount());
        return "bankaccount"; //customer.html template
    }


    @PostMapping//////("/customer")
    public String registerBankAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        bankAccountService.createBankaccount(bankAccount);
        model.addAttribute("allBankaccount", bankAccountService.getBankAccount());
        return "redirect:bankaccount";
    }
}
