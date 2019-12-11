package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//无情注解开发

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户的web层
 */
@Controller
@RequestMapping("/accountController")
public class AccountController {

    @Autowired   // 这个注解是自动注入的意思
    private AccountService accountService;

    /**
     * 查询用户信息
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){

        System.out.println("表现层:查询所有账户............");
        //调用service的方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list" ,list );
        return "success";
    }

    /**
     * 保存用户数据
     * @param account
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account , HttpServletRequest request, HttpServletResponse response) throws Exception {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/accountController/findAll");
        return;
    }
}
