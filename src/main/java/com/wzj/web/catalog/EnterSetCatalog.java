package com.wzj.web.catalog;

import com.wzj.model.EnterSet;
import com.wzj.service.service.EnterSetService;
import com.wzj.service.service.GatheringCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/enterSet/")
public class EnterSetCatalog {
    @Autowired
    private EnterSetService enterSetService;
    @Autowired
    private GatheringCodeService gatheringCodeService;
    /**
     *入驻设置
     * */
    @GetMapping("jumpEnterSet")
    public String jumpUpdate(Long id,HttpServletRequest request){
        EnterSet enterSet=enterSetService.findById(id);
        request.setAttribute("enterSet",enterSet);
        return "WEB-INF/views/admin/baseSet/enterSet";
    }


    /**
     *跳转至收款码修改
     * */
    @GetMapping("jumpGatheringCodeUpdate")
    public String jumpGatheringCodeUpdate(HttpServletRequest request){
        request.setAttribute("gatheringCode",gatheringCodeService.findById(1L));
        return "WEB-INF/views/admin/baseSet/gatheringCodeUpdate";
    }

}
