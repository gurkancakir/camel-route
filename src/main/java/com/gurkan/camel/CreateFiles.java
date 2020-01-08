package com.gurkan.camel;

import java.io.File;
import java.io.IOException;

public class CreateFiles {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 200000; i++) {
            File file = new File("/Users/gurkancakir/Downloads/camel-route/Test"+i+".pdf");
            file.createNewFile();
        }
    }
}
