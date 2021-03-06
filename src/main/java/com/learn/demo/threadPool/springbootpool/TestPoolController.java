package com.learn.demo.threadPool.springbootpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestPoolController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async(){
        asyncService.executeAsync();
    }
}
