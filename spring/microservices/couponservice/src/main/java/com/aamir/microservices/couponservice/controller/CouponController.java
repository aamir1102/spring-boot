package com.aamir.microservices.couponservice.controller;

import com.aamir.microservices.couponservice.exceptions.CouponException;
import com.aamir.microservices.couponservice.model.Coupon;
import com.aamir.microservices.couponservice.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

    @Autowired
    CouponService couponService;

    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons(){
        return couponService.getAllCoupons();
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCouponByCode(@PathVariable("code") String code){
        Coupon coupon = couponService.getCouponByCode(code);
        if(coupon==null)
            throw new CouponException("coupon with code -> "+code+" doesn't exist");
        return coupon;
    }

    @GetMapping("/coupons/id/{id}")
    public Coupon getCouponById(@PathVariable("id") Long id){
        Coupon coupon = couponService.getCouponById(id);
        if(coupon==null)
            throw new CouponException("coupon with id -> "+id +" doesn't exists");
        return coupon;

    }

    @PostMapping("/coupons")
    public Coupon saveCoupon(@RequestBody Coupon coupon){
        return couponService.saveCoupon(coupon);
    }

    @PutMapping("/coupons")
    public Coupon updateCoupon(@RequestBody Coupon coupon){
        Coupon couponCheck = couponService.getCouponById(coupon.getId());
        if(couponCheck==null)
            throw new CouponException("coupon with code -> "+coupon.getCode() +" doesn't exists");
        return couponService.updateCoupon(coupon);
    }

    @DeleteMapping("/coupons/id/{id}")
    public String deleteCouponById(@PathVariable("id") Long id){
        Coupon coupon = couponService.getCouponById(id);
        if(coupon==null)
            throw new CouponException("Cannot delete as coupon with id -> "+id+" doesn't exist");
        couponService.deleteCouponById(id);
        return "coupon with id ->"+id+" deleted!";
    }

    @DeleteMapping("/coupons/{code}")
    public String deleteCoupon(@PathVariable("code") String code){
        Coupon coupon = couponService.getCouponByCode(code);
        if(coupon==null)
            throw new CouponException("coupon with code -> "+code +" doesn't exists");
        couponService.deleteCoupon(coupon);
        return "coupon with code ->"+code+" deleted!";
    }

    @DeleteMapping("/coupons/code/{code}")
    public String deleteByCode(@PathVariable("code") String code){
        Coupon coupon = couponService.getCouponByCode(code);
        if(coupon==null)
            throw new CouponException("coupon with code -> "+code +" doesn't exists");
        couponService.deleteByCode(code);
        return "coupon with code ->"+code+" deleted!";
    }

}
