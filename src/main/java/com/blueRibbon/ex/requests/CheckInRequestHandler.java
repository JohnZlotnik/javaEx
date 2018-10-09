package com.blueRibbon.ex.requests;

import com.blueRibbon.ex.DbMockup;
import com.blueRibbon.ex.FlightsAppExApplication;
import com.blueRibbon.ex.utils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by Dell on 09/10/2018.
 *
 */
public class CheckInRequestHandler implements HttpHandler {

    private static final Logger logger = LoggerFactory.getLogger(CheckInRequestHandler.class);


    public synchronized boolean checkIn(int destinationId, String baggageId){
        if (DbMockup.getInstance().getCheckedIn().containsKey(destinationId)){
            if (!DbMockup.getInstance().getCheckedIn().get(destinationId).contains(baggageId)){
                DbMockup.getInstance().getCheckedIn().get(destinationId).add(baggageId);
                return true;
            }
        }
        return false;
    }



    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        logger.debug("received check in http request");
        String response;
        Map<String,String > queries = utils.getQueryMap(httpExchange.getRequestURI().getQuery());
        if (checkIn(Integer.valueOf(queries.get("destination")), queries.get("baggage"))){
            response = "check in succeeded";
        }
        else {
            response = "check in failed";
        }
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
}
