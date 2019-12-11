package cn.itcast.controller;


import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//无情安排

import javax.annotation.security.PermitAll;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    //给用户添加角色
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId" , required = true) Integer userId ,@RequestParam(name = "ids" , required = true) Integer[] roleIds){
            userService.addRoleToUser(userId , roleIds);

            return "redirect:findAll.do";
    }


    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id" , required = true) Integer userid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(userid);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles =  userService.findOtherRoles(userid);

        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }


    //查询指定id的用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception{

        ModelAndView mv = new ModelAndView();

        UserInfo userInfo =  userService.findById(id);
        //封装这个对象  并且这个  user 起名称  要对应jsp页面上JSTL标签里面的作用域对象
        mv.addObject("user" , userInfo);
        //然后去相对应的页面去展示
        mv.setViewName("user-show");
        return mv;
    }



    //用户添加
    @RequestMapping("/save.do")
    //这句代码的意思是只有tom用户才能对用户添加进行操作,其他人都不行
    // @PreAuthorize("authentication.principal.username =='tom'")
    public String  save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }


    @RequestMapping("/findAll.do")
    //这个是只有ADMIN权限用户可以查询产品
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll() throws Exception{

        ModelAndView mv = new ModelAndView( );
        List<UserInfo>  userList =  userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }
}
