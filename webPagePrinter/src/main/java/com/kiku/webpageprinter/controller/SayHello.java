package com.kiku.webpageprinter.controller;

import com.kiku.webpageprinter.utils.Base64ToImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
public class SayHello {

    @Value("${filePathPrefix}")
    private String filePathPrefix;

    @GetMapping("/sayHello")
    public Object sayHello() {
        return "hello";
    }


    @PostMapping("/Base64Toimg2")
    public Boolean Base64Toimg2(@RequestBody String base64str) throws IOException {
        if (base64str.indexOf(",") != -1) {
            base64str = base64str.split(",")[1];
        }
        String imgName = UUID.randomUUID().toString();
        Boolean bl = Base64ToImg.GenerateImage(base64str, filePathPrefix + imgName + ".png");
        return bl;
    }

}
