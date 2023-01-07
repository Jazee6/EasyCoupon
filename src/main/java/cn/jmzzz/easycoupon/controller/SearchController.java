package cn.jmzzz.easycoupon.controller;

import cn.jmzzz.easycoupon.controller.utils.Code;
import cn.jmzzz.easycoupon.controller.utils.Msg;
import cn.jmzzz.easycoupon.controller.utils.R;
import cn.jmzzz.easycoupon.service.GoodsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private final GoodsQuery goodsQuery;

    @Autowired
    public SearchController(GoodsQuery goodsQuery) {
        this.goodsQuery = goodsQuery;
    }

    @GetMapping("/search")
    public R search(String keyword) throws Exception {
        return new R(Code.SUCCESS, Msg.SUCCESS, goodsQuery.getByKeyword(keyword));
    }
}
