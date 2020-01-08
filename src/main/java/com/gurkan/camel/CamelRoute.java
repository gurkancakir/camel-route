package com.gurkan.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {

    private final String PATH = "file:/Users/gurkancakir/Downloads/camel-route/?include=.*.pdf&recursive=true&noop=true"
            +"&preMove=/Users/gurkancakir/Downloads/camel-route-import/";

    private final String direct = "direct:moveFile";
    @Autowired
    CamelRouteProcessor camelRouteProcessor;
    @Autowired
    CamelRouteDoneProcessor camelRouteDoneProcessor;

    @Override
    public void configure() throws Exception {
        from(PATH).process(camelRouteProcessor).to(direct);

        from(direct).process(camelRouteDoneProcessor);
    }
}
