package com.wzj.web.controller;
import com.wzj.model.WeChatPublicConfig;
import com.wzj.service.service.WeChatPublicConfigService;
import com.wzj.enums.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;
import springfox.documentation.annotations.ApiIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/02.
 */
@ApiIgnore
@RestController
@RequestMapping("/weChatPublicConfig/")
public class WeChatPublicConfigController {

    @Autowired
    private WeChatPublicConfigService weChatPublicConfigService;

    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(WeChatPublicConfig weChatPublicConfig) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        weChatPublicConfig.setAddTime(simpleDateFormat.format(new Date()));
        weChatPublicConfig.setModifyTime(simpleDateFormat.format(new Date()));
        weChatPublicConfigService.save(weChatPublicConfig);
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    weChatPublicConfigService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(WeChatPublicConfig weChatPublicConfig) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        weChatPublicConfig.setModifyTime(simpleDateFormat.format(new Date()));
	    weChatPublicConfigService.update(weChatPublicConfig);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(id);
        return Result.retrunSucessMsgData(weChatPublicConfig);
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        Example example=new Example(WeChatPublicConfig.class);
        Example.Criteria criteria=example.createCriteria();
        PageHelper.startPage(page, limit);
        PageInfo<WeChatPublicConfig> weChatPublicConfigPageInfo = weChatPublicConfigService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(weChatPublicConfigPageInfo.getList());
        map.put("count",weChatPublicConfigPageInfo.getTotal());
        return map;
    }
}
