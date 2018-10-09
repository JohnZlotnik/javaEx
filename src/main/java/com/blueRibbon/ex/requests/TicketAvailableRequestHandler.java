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

/**
 * Created by Dell on 09/10/2018.
 *
 */
public class TicketAvailableRequestHandler implements HttpHandler {

    private static final Logger logger = LoggerFactory.getLogger(TicketAvailableRequestHandler.class);


    public synchronized boolean checkIfTicketAvailable(int ticketId) {
        return DbMockup.getInstance().getAvailableTickets().contains(ticketId);
    }


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        logger.debug("received ticket available http request");

        String response;
        Map<String,String > queries = utils.getQueryMap(httpExchange.getRequestURI().getQuery());
        if (checkIfTicketAvailable(Integer.valueOf(queries.get("ticketId")))){
            response = "ticket is available";
        }
        else {
            response = "ticket is unavailable";
        }
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
