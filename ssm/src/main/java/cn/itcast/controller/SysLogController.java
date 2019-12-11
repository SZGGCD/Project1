package cn.itcast.controller;


import cn.itcast.domain.SysLog;
import cn.itcast.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.net.SyslogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page" , required = true , defaultValue = "1") Integer page ,
                                @RequestParam(name = "size" , required = true , defaultValue = "8") Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
       List<SysLog> sysLogList= sysLogService.findAll(page,size);
        //PageInfo 就是一个分页Bean
        PageInfo pageInfo = new PageInfo(sysLogList);
        mv.addObject("pageInfo" , pageInfo);
//        mv.addObject("sysLogs",sysLogList);
        mv.setViewName("syslog-page-list");
        return mv;
    }
}
