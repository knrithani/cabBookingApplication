package com.project.cabbooking.admin;

import com.project.cabbooking.customer.CustomerAccount;

public interface AdminService {
    CustomerAccount registerUser(CustomerAccount account);
}
