package cn.jmzzz.easycoupon.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class RefererFilter implements HandlerInterceptor {

    private final String[] whitelist;

    public RefererFilter(String[] whitelist) {
        this.whitelist = whitelist;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println(Arrays.toString(whitelist));
        String referer = request.getHeader("Referer");
        if (referer == null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        URL refererUrl;
        try {
            refererUrl = new URL(request.getHeader("Referer"));
        } catch (MalformedURLException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        for (String domain : whitelist) {
            if (refererUrl.getHost().equals(domain)) {
                return true;
            }
        }
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return false;
    }
}
