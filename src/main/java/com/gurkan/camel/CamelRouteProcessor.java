package com.gurkan.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class CamelRouteProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        File file = exchange.getIn().getBody(File.class);
        exchange.getIn().setBody(file.getCanonicalPath());
        System.out.println("reading a file : " + file.getCanonicalPath());
    }
}
