package edu.njust.controller;


import edu.njust.pojo.*;
import edu.njust.service.BackStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ManageController {
    @Autowired
    private BackStageService service;

    /*处理查询菜品类型请求*/
    @RequestMapping("/DishType")
    public String toManageDishType(Model model){
        List<DishType> all = service.allDishType();
        List<Dish> dishByType = null;
        if(all != null){
            dishByType = service.allDishByType(all.get(0));
        }
        model.addAttribute("types",all);
        model.addAttribute("dishByType",dishByType);
        return "backstage/dishManage";
    }

    /*处理查询某一特定菜品类型的所有菜品请求*/
    @RequestMapping("/queryDish")
    public String queryDish(int typeId, Model model){
/*        System.out.println(typeId);*/
        DishType type = service.getDishTypeById(typeId);
        List<DishType> all = service.allDishType();
        List<Dish> list = service.allDishByType(type);
        if(list != null){
            model.addAttribute("types",all);
            model.addAttribute("dishByType",list);
            return "backstage/dishManage";
        }
        return "admin/DishType";
    }

    /*处理到新增菜品页面的请求*/
    @RequestMapping("/toCreateDish")
    public String toCreateDish(Model model){
        List<DishType> allType = service.allDishType();
        model.addAttribute("type",allType);
        return "backstage/xxx";
    }

    /*处理新增菜品的请求*/
    @RequestMapping("/createDish")
    public String createDish(Dish dish, Model model){
        boolean flag = service.addDish(dish);
        if(flag == false){
            model.addAttribute("msg","添加错误");
            return "";
        }
        return "";
    }

    /*处理进入到历史账单管理页面的请求跳转*/
    @RequestMapping("/toHistoryBill")
    public String toHistoryBill(Model model){
        List<Orders> list = service.historyOrders();
        model.addAttribute("historyBill",list);
        return "backstage/history_bill";
    }

    /*处理进入到活账单管理页面的请求跳转*/
    @RequestMapping("/toLivingBill")
    public String toLivingBill(Model model){
        List<Orders> list = service.allLivingOrders();
        model.addAttribute("livingBill",list);
        return "backstage/live_bill";
    }

    /*处理进入到餐桌管理页面的请求*/
    @RequestMapping("/toManageTable")
    public String toManageTable(Model model){
        List<Tables> list = service.allTables();
        model.addAttribute("tables",list);
        return "backstage/table";
    }

    /*处理跳转到修改账号信息页面的请求*/
    @RequestMapping("/toModifyAccount")
    public String toModifyAccount(Model model, HttpServletRequest request){
        Admin curUser = service.getAdminByUsr((String) request.getSession().getAttribute("curUser"));
        if(curUser != null){
            model.addAttribute("user",curUser);
        }
        return "backstage/account";
    }

    /*1.处理用户修改账号信息的请求*/
    @RequestMapping("/modifyAccount")
    public String modifyAccount(Admin admin, Model model){
        System.out.println(admin);
        boolean state = service.updateAccount(admin);
        if(state == false){
            model.addAttribute("msg","异常，请重新登录");
            return "sign-in";
        }
        model.addAttribute("msg","修改成功，请重新登录");
        return "sign-in";
    }
}
