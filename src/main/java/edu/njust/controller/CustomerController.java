package edu.njust.controller;

import edu.njust.pojo.Dish;
import edu.njust.pojo.DishType;
import edu.njust.pojo.DishesWithType;
import edu.njust.service.BackStageService;
import edu.njust.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private BackStageService service;

    /*处理顾客端页面菜单初始化的请求*/
    @RequestMapping("/menu")
    public String toMenu(Model model){
        List<DishType> allTypes = service.allDishType();
        List<DishesWithType> allDishes = new LinkedList<>();
        for(DishType type:allTypes){
            List<Dish> dishes = service.allDishByType(type);
            DishesWithType dishesWithType = new DishesWithType(type,dishes);
            allDishes.add(dishesWithType);
        }
        model.addAttribute("types",allTypes);
        model.addAttribute("dishes",allDishes);
        return "order";
    }


    /*处理客户的点餐需求
    * 参数: 餐桌编号 tableId, 由点的菜品编号组成的字符串 numOfDishes
    * 返回页面: 初始顾客端页面
    * */
    @RequestMapping("/order")
    public String orderDish(int tableId, String numOfDishes, Model model){
        return "";
    }

    /*处理顾客的加菜请求*/
}
