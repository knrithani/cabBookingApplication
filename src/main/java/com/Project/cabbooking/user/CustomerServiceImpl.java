package com.Project.cabbooking.user;

import com.Project.cabbooking.user.CustomerRepository;
import com.Project.cabbooking.user.CustomerAccount;
import com.Project.cabbooking.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerAccount login(String cdsId, String userPassword){
        Optional<CustomerAccount> accountOpt = this.customerRepository.findByCdsId(cdsId);
        /*if(accountOpt.isEmpty()){

        }*/
        CustomerAccount foundAccount = accountOpt.get();
        if(foundAccount.getPassword().equals(userPassword)){
            return foundAccount;
        }
        return null;
    }

}
