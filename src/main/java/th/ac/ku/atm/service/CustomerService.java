package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customerList;

    @PostConstruct
    public void postConstruct(){
        this.customerList = new ArrayList<>();
    }
    public void createCustomer(Customer customer){
        //.... hash pin for customer  ...
        String hashPin=hash(customer.getPin());
        customer.setPin(hashPin);
        customerList.add(customer);
    }
    public List<Customer> getCustomers(){
        return new ArrayList<>(this.customerList);
    }

    public Customer findCustomer(int id) {
        for (Customer customer:customerList){
            if (customer.getId() == id)
                return customer;
        }
        return null;
    }
    public Customer checkPin( Customer inputCustomer) {
// 1. หา customer ทม 􀑷ี ี id ตรงกับ พารามิเตอร์
        Customer storedCustomer = findCustomer(inputCustomer.getId());
// 2. ถา้ มี id ตรง ใ หเ้ ช็ค pin ว่า ตรงกันไ หม โ ดยใ ช ฟั้งก์ชันเ กย􀑷ี วกับ hash
        if ( storedCustomer != null) {
            String hashPin = storedCustomer.getPin();
            if (BCrypt.checkpw(inputCustomer.getPin(),hashPin) )
            return storedCustomer;
        }
// 3. ถา้ ไ ม่ ตรง ตอ้ ง คืน ค่า null
        return null;
    }

    private String hash(String pin){
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin,salt);
    }

}
