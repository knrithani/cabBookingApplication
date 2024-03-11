package com.Project.cabbooking.booking;

import com.Project.cabbooking.car.CarAccount;
import com.Project.cabbooking.ride.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    static List<Booking> findByCdsIdAscs(){
        return null;
    };

    static List<Ride> findByDriverIdAscs() {
        return null;
    }

//    public List<Booking> findByCdsidAscs( ) ;
//     public List<Booking> findByDriverdIdAscs();

}
