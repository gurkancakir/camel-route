package com.gurkan.camel;

import com.gurkan.camel.entity.FileEntity;
import com.gurkan.camel.repository.FileRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class CamelRouteDoneProcessor implements Processor {

    @Autowired
    FileRepository fileRepository;

    @Override
    public void process(Exchange exchange) throws Exception {
        String filePath = exchange.getIn().getBody(String.class);
        FileEntity fileEntity = new FileEntity();
        fileEntity.setPath(filePath);
        fileRepository.save(fileEntity);
        System.out.println("imported file : " +filePath);

        File file = new File(filePath);
        file.renameTo(new File(filePath.replace("/camel-route-import/", "/camel-route-done/")));
    }
}
