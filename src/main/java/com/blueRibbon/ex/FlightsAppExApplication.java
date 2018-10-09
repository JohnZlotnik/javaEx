package com.blueRibbon.ex;

import com.blueRibbon.ex.requests.CheckInRequestHandler;
import com.blueRibbon.ex.requests.CoupunRequestHandler;
import com.blueRibbon.ex.requests.TicketAvailableRequestHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

@SpringBootApplication
public class FlightsAppExApplication implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(FlightsAppExApplication.class);


    public static void main(String[] args) {
		SpringApplication.run(FlightsAppExApplication.class, args);
	}


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        createRequestsHandlers(server);
        server.setExecutor(null); // creates a default executor
        server.start();
        logger.info("FlightsAppExApplication started");
    }

    private void createRequestsHandlers(HttpServer server ){
        logger.debug("creating http request handlers");
        server.createContext("/isTicketAvailable", new TicketAvailableRequestHandler());
        server.createContext("/checkIn", new CheckInRequestHandler());
        server.createContext("/Coupon", new CoupunRequestHandler());
    }


}
