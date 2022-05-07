//package com.hello.interceptor;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import io.seata.core.context.RootContext;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @author zsk
// * @version 1.0
// * @date 2022-05-04 21:11
// */
//@Component
//public class FeignClientInterceptor implements RequestInterceptor {
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attributes != null){
//            HttpServletRequest request = attributes.getRequest();
//            requestTemplate.header(HttpHeaders.AUTHORIZATION,request.getHeader(HttpHeaders.AUTHORIZATION));
//        }
//        String xid = RootContext.getXID();
//        if (!StringUtils.isEmpty(xid)){
//            requestTemplate.header(RootContext.KEY_XID,xid);
//        }
//    }
//
//}
