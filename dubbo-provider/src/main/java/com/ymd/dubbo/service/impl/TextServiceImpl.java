package com.ymd.dubbo.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymd.dubbo.service.ITextService;
import com.ymd.mybatis.entity.TextInfo;
import com.ymd.mybatis.mapper.TextInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("textServiceImpl")
public class TextServiceImpl extends ServiceImpl<TextInfoMapper,TextInfo> implements ITextService {


    @Autowired
    private TextInfoMapper textInfoMapper;

    @Override
    public String getInfo() {

        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        // 获取调用方IP地址
        String clientIp = RpcContext.getContext().getRemoteHost();
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String url = RpcContext.getContext().getUrl().toFullString();

        Map<String,Object>  map = new HashMap<>();
        map.put("isProviderSide",isProviderSide);
        map.put("clientIp",clientIp);
        map.put("url",url);

        return JSON.toJSONString(map);
    }

    @Override
    public String getText() {

        log.info("------------------这是A-------------------");
        List<TextInfo> textInfos = textInfoMapper.selectByMap(null);
        return JSON.toJSONString(textInfos);

    }
}
