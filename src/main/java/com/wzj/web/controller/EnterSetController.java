package com.wzj.web.controller;
import com.wzj.model.EnterSet;
import com.wzj.service.service.EnterSetService;
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
 * Created by Zongjie Wu on 2019/04/01.
 */
@ApiIgnore
@RestController
@RequestMapping("/enterSet/")
public class EnterSetController {

    @Autowired
    private EnterSetService enterSetService;

    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(EnterSet enterSet) {
        enterSetService.save(enterSet);
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    enterSetService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(EnterSet enterSet) {
	    enterSetService.update(enterSet);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        EnterSet enterSet = enterSetService.findById(id);
        return Result.retrunSucessMsgData(enterSet);
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        Example example=new Example(EnterSet.class);
        Example.Criteria criteria=example.createCriteria();
        PageHelper.startPage(page, limit);
        PageInfo<EnterSet> enterSetPageInfo = enterSetService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(enterSetPageInfo.getList());
        map.put("count",enterSetPageInfo.getTotal());
        return map;
    }
}
