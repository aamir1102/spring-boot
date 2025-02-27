package com.aamir.microservices.couponservice.repos;

import com.aamir.microservices.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Long> {

    void deleteByCode(String code);
    Coupon findByCode(String code);
}
