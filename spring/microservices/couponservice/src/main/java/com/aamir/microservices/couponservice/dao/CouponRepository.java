package com.aamir.microservices.couponservice.dao;

import com.aamir.microservices.couponservice.model.Coupon;
import com.aamir.microservices.couponservice.repos.CouponRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CouponRepository {

    @Autowired
    CouponRepo couponRepo;

    public Coupon saveCoupon(Coupon coupon){
        return couponRepo.save(coupon);
    }

    public Coupon getCouponById(Long id){
        Optional<Coupon> coupon = couponRepo.findById(id);
        return coupon.orElse(null);
    }

    public List<Coupon> getAllCoupons(){
        return couponRepo.findAll();
    }
    public Coupon getCouponByCode(String code){
        return couponRepo.findByCode(code);
    }

    public Coupon updateCoupon(Coupon coupon){
        return couponRepo.save(coupon);
    }

    public void deleteCouponById(Long id){
        couponRepo.deleteById(id);
    }

    public void deleteCoupon(Coupon coupon){
        couponRepo.delete(coupon);
    }

    public void deleteByCode(String code){
        couponRepo.deleteByCode(code);
    }


}
