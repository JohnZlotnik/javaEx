package com.blueRibbon.ex.requests;

import com.blueRibbon.ex.DbMockup;
import com.blueRibbon.ex.utils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Random;

/**
 * Created by Dell on 09/10/2018.
 *
 */
public class CoupunRequestHandler implements HttpHandler {

    private static final Logger logger = LoggerFactory.getLogger(CheckInRequestHandler.class);


    private int[] discountAr = {10,50,60};

    public synchronized boolean checkCoupon(int couponId){
        return DbMockup.getInstance().getValidCoupons().contains(couponId);
    }


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        logger.debug("received coupon http request");
        String response;
        Map<String,String > queries = utils.getQueryMap(httpExchange.getRequestURI().getQuery());
        if (checkCoupon(Integer.valueOf(queries.get("couponId")))){
            int rand = new Random().nextInt(discountAr.length);
            int discount = discountAr[rand];
            response = "discount is " + discount;

        }
        else {
            response = "coupon id is invalid";
        }
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
