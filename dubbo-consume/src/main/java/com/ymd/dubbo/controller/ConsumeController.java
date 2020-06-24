package com.ymd.dubbo.controller;

import com.ymd.dubbo.service.ITextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo/consume/")
public class ConsumeController {

    @Autowired
    private ITextService textService;

    @GetMapping("one")
    public String  getInfo(){
        return textService.getInfo();
    }

    @GetMapping("two")
    public String  getTextInfo(){
        return textService.getText();
    }

}
