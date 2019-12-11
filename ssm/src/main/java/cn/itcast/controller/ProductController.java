package cn.itcast.controller;

import cn.itcast.domain.Product;
import cn.itcast.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//
//        binder.registerCustomEditor(Date.class, new MyDateEdit("yyyy-MM-dd HH:mm"));
//
//    }


    /**
     * 查询全部产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    //使用RolesAllowed这个注解时 ,可以省略前缀
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 产品添加
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {

        productService.save(product);
        return "redirect:findAll.do";


    }
}
