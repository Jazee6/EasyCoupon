package cn.jmzzz.easycoupon.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.net.MalformedURLException;
import java.net.URL;

public class RefererFilter implements HandlerInterceptor {

    private final String[] whitelist;

    public RefererFilter(String[] whitelist) {
        this.whitelist = whitelist;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String referer = request.getHeader("Referer");
        if (referer == null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        URL refererUrl;
        try {
            refererUrl = new URL(referer);
        } catch (MalformedURLException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }

        for (String domain : whitelist) {
            if (refererUrl.getHost().equals(domain)) {
                response.setHeader("Access-Control-Allow-Origin", refererUrl.getProtocol() + "://" + refererUrl.getHost() + (refererUrl.getPort() == -1 ? "" : ":" + refererUrl.getPort()));
                // 临时解决CORS
                return true;
            }
        }
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return false;
    }
}
