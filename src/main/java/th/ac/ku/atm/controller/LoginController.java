package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.CustomerService;

@Controller
@RequestMapping("/login")
public class LoginController {
    private CustomerService customerService;
    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String etLoginPage( ) {
        return "login"; // return login.html
    }

    @PostMapping
    public String login(@ModelAttribute Customer customer, Model model) {
// 1. เ อา id กับ pin ไ ปเ ช็คกับ ขอ้ มูล customer ทม 􀑷ี ีอ ยู่ ว่า ตรงกัน บา้ งไ หม
        Customer matchingCustomer = customerService.checkPin(customer);
// 2. ถา้ ตรง ส่ง ขอ้ มูล customer ก ลับไ ปแ สดง ผล
        if (matchingCustomer != null) {
            model.addAttribute("greeting"," Welcome, " + matchingCustomer.getName());
        } else {
// 3. ถา้ ไ ม่ ตรง แ จง้ ว่าไ ม่มี ขอ้ มูล customer น 􀑸ี
            model.addAttribute("greeting"," Can't find customer");
        }
        return "home";
    }
}
