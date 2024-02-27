package com.Project.cabbooking.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class DriverServicesImpl implements DriverServices{

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public DriverAccount login(String userEmailId, String userPassword) throws DriverExceptions {
        Optional<DriverAccount> accountOpt = this.driverRepository.findByEmailId(userEmailId);
        if(accountOpt.isEmpty()){
            throw new DriverExceptions("Account does not exist");
        }
        DriverAccount foundAccount = accountOpt.get();
        if(!foundAccount.getPassword().equals(userPassword)){
            throw new DriverExceptions("Password Incorrect");
        }
        return foundAccount;
    }

    @Override
    public String applyForLeave(Integer id, LocalDate LeaveDate)
    {

        LocalDate today =LocalDate.now();
        LocalDate twodaysafter = today.plus(2, ChronoUnit.DAYS);

        if( LeaveDate.equals(twodaysafter)) {
        return "Leave Applied Successfully"+ id+"for the date "+ LeaveDate;
        }
        else
            return "Cannot apply leave for the dates"+ LeaveDate;

    }




        

    }





