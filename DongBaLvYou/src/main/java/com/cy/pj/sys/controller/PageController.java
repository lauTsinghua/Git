package com.cy.pj.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {

    /**
     * starter会返回给DispatcherServlet对象
     * DispatcherServlet会将viewname交给视图解析器
     * 视图解析器会在viewname的基础之上添加前缀和后缀.并进行解析
     * 视图解析器会将解析的结果返回给DispatcherServlet
     * DispatcherServlet会将结果响应到客户端
     */

    @RequestMapping("doIndexUI")//http://localhost:8080/doIndexUI
    public String doIndexUI() {
        return "starter";
    }

    /**这两段代码可被String doModuleUI(){}下面的这段代码所替代

     @RequestMapping("/log/log_list") public String doLogUI() {

     return "sys/log_list";
     }

     @RequestMapping("/menu/menu_list") public String doMenuUI() {
     return "sys/menu_list";
     }**/
    /**
     * REST风格的url映射:
     * <p>
     * REST是一种软件架构编码风格,在这种风格下的url定义,可以用{变量}的方式使url更加简单通用.
     * 在方法参数中需要url中的{变量}时,需要使用@PathVariable这个注解
     * 对方法参数进行描述，并且要求方法参数的名字要与{变量}表达式中的变量名相同。
     */
    @RequestMapping("/{module}/{moduleUI}")
    public String doModuleUI(@PathVariable String moduleUI) {//@PathVariable表示这个注解修饰的变量的值来自于和这个变量同名的url里面
        return "sys/" + moduleUI;
    }


    @RequestMapping("doPageUI")
    public String doPageUI() {

        return "common/page";
    }

}
