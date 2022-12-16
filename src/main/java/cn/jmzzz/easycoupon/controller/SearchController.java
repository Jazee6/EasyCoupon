package cn.jmzzz.easycoupon.controller;

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
    public String search(String keyword) throws Exception {
        return goodsQuery.getByKeyword(keyword);
    }
}
