package com.wzj.web.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.enums.Result;
import com.wzj.model.EnterSet;
import com.wzj.model.GatheringCode;
import com.wzj.service.service.EnterSetService;
import com.wzj.service.service.GatheringCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
@ApiIgnore
@RestController
@RequestMapping("/api/enterSet/")
public class ApiEnterSet {

    @Autowired
    private EnterSetService enterSetService;
    @Autowired
    private GatheringCodeService gatheringCodeService;

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
    @PostMapping("all")
    public Map<String,Object> all() {
        List<EnterSet> enterSetList=enterSetService.findAll();
        GatheringCode gatheringCode=gatheringCodeService.findById(1L);
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("enterSet",enterSetList);
        paramMap.put("gatheringCode",gatheringCode.getImg());
        return Result.retrunSucessMsgData(paramMap);
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
