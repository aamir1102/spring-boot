package com.aamir.microservices.couponservice.service;

import com.aamir.microservices.couponservice.dao.CouponRepository;
import com.aamir.microservices.couponservice.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public Coupon saveCoupon(Coupon coupon){
        return couponRepository.saveCoupon(coupon);
    }

    public Coupon getCouponById(Long id){
        return couponRepository.getCouponById(id);
    }

    public List<Coupon> getAllCoupons(){
        return couponRepository.getAllCoupons();
    }
    public Coupon getCouponByCode(String code){
        return couponRepository.getCouponByCode(code);
    }

    public Coupon updateCoupon(Coupon coupon){
        return couponRepository.updateCoupon(coupon);
    }

    public void deleteCouponById(Long id){
        couponRepository.deleteCouponById(id);
    }

    public void deleteCoupon(Coupon coupon){
        couponRepository.deleteCoupon(coupon);
    }

    public void deleteByCode(String code){
        couponRepository.deleteByCode(code);
    }

}
