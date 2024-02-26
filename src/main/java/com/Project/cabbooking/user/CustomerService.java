package com.Project.cabbooking.user;

import com.Project.cabbooking.user.CustomerAccount;

public interface CustomerService {
    CustomerAccount login(String cdsId, String password);
}
