package com.Project.cabbooking;

import com.Project.cabbooking.driver.DriverAccount;
import com.Project.cabbooking.driver.DriverRepository;
import com.Project.cabbooking.user.CustomerAccount;
import com.Project.cabbooking.user.CustomerRepository;
import com.Project.cabbooking.user.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class CabBookingApplicationTests {

	@Autowired CustomerRepository customerRepository;
	@Autowired DriverRepository driverRepository;

	@Test
	void userLogin() {
		CustomerAccount customerAccount=new CustomerAccount();
		customerAccount.setAddress("NP apartments");
		customerAccount.setId(1);
		customerAccount.setName("Nisha");
		customerAccount.setPassword("Nis@123");
		customerAccount.setCdsId("NP19");
		customerAccount.setPhoneNumber(8765334562L);
		Assert.notNull(customerRepository.findByCdsId("NP19"),"USER FOUND IN DB");
	}

	void driverLogin(){
		DriverAccount driverAccount=new DriverAccount();
		driverAccount.setDriverid("D1");
		driverAccount.setid(2);
		driverAccount.setName("Praga");
		driverAccount.setPassword("Dri@123");
		driverAccount.setPhoneNumber(8746728738L);
		driverAccount.setEmailId("Dri@gmail.com");
		driverAccount.setLicenseNumber(Long.valueOf("DR1364785789036"));
		Assert.notNull(driverRepository.findByDriverid("D1"),"DRIVER FOUND IN DB");


	}

}
