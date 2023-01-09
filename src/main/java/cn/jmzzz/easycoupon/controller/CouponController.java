package cn.jmzzz.easycoupon.controller;

import cn.jmzzz.easycoupon.controller.utils.R;
import cn.jmzzz.easycoupon.service.GoodsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    GoodsQuery goodsQuery;

    @Autowired
    CouponController(GoodsQuery goodsQuery) {
        this.goodsQuery = goodsQuery;
    }

    @GetMapping("/coupon")
    public R coupon(String goodsId, String searchId) throws Exception {
        return new R(goodsQuery.getCoupon(goodsId, searchId));
    }

}
