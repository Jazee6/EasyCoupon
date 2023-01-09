package cn.jmzzz.easycoupon.service;

import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPromotionUrlGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsSearchRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPromotionUrlGenerateResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class GoodsQuery {
    PopClient client;

    @Value("${pdd.key}")
    private String KEY;

    @Value("${pdd.secret}")
    private String SECRET;

    @Value("${pdd.pid}")
    private String PID;

    public List<PddDdkGoodsSearchResponse.GoodsSearchResponseGoodsListItem> getByKeyword(String keyword) throws Exception {
        if (client == null) {
            client = new PopHttpClient(KEY, SECRET);
        }
        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        request.setKeyword(keyword);
        request.setPid(PID);
        request.setWithCoupon(true);
        request.setUseCustomized(false);
        request.setSortType(0);

        Future<PddDdkGoodsSearchResponse> futureResponse = client.asyncInvoke(request);
        return futureResponse.get().getGoodsSearchResponse().getGoodsList();
    }

    public List<PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItem> getCoupon(String goodsId, String searchId) throws Exception {
        if (client == null) {
            client = new PopHttpClient(KEY, SECRET);
        }
        PddDdkGoodsPromotionUrlGenerateRequest request = new PddDdkGoodsPromotionUrlGenerateRequest();
        request.setPId(PID);
        request.setGoodsSignList(List.of(goodsId));
        request.setSearchId(searchId);
        request.setGenerateSchemaUrl(true);

        PddDdkGoodsPromotionUrlGenerateResponse response = client.syncInvoke(request);
        return response.getGoodsPromotionUrlGenerateResponse().getGoodsPromotionUrlList();
    }

}
