package com.wzj.web.controller;
import com.wzj.model.GatheringCode;
import com.wzj.service.service.GatheringCodeService;
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
 * Created by Zongjie Wu on 2019/04/24.
 */
@ApiIgnore
@RestController
@RequestMapping("/gatheringCode/")
public class GatheringCodeController {

    @Autowired
    private GatheringCodeService gatheringCodeService;

    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(GatheringCode gatheringCode) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gatheringCode.setAddTime(simpleDateFormat.format(new Date()));
        gatheringCode.setModifyTime(simpleDateFormat.format(new Date()));
        gatheringCodeService.save(gatheringCode);
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    gatheringCodeService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(GatheringCode gatheringCode) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gatheringCode.setModifyTime(simpleDateFormat.format(new Date()));
	    gatheringCodeService.update(gatheringCode);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        GatheringCode gatheringCode = gatheringCodeService.findById(id);
        return Result.retrunSucessMsgData(gatheringCode);
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        Example example=new Example(GatheringCode.class);
        Example.Criteria criteria=example.createCriteria();
        PageHelper.startPage(page, limit);
        PageInfo<GatheringCode> gatheringCodePageInfo = gatheringCodeService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(gatheringCodePageInfo.getList());
        map.put("count",gatheringCodePageInfo.getTotal());
        return map;
    }
}
