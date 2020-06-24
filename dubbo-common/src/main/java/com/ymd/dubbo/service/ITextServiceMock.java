package com.ymd.dubbo.service;

public class ITextServiceMock implements ITextService {
    @Override
    public String getInfo() {
        return "不好意思，服务出现了故障------info";
    }

    @Override
    public String getText() {
        return "不好意思，服务出现了故障------text";
    }
}
