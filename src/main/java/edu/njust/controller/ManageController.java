package edu.njust.controller;


import edu.njust.pojo.Dish;
import edu.njust.pojo.DishType;
import edu.njust.pojo.Orders;
import edu.njust.service.BackStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
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
    public String queryDish(DishType type, Model model){
        System.out.println(type);
        List<Dish> list = service.allDishByType(type);
        if(list != null){
            model.addAttribute("dishByType",list);
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
}
