package edu.njust.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.njust.pojo.Dish;
import edu.njust.pojo.DishType;
import edu.njust.pojo.DishesWithType;
import edu.njust.service.BackStageService;
import edu.njust.service.CustomerService;
import edu.njust.utils.ResponseWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private BackStageService service;

    /*处理初始化点餐页面的请求*/
    @RequestMapping("/menu")
    public String toMenu(HttpServletResponse response) throws IOException {
        List<DishType> dishTypes = service.allDishType();
        List<DishesWithType> dishesWithTypes = service.getAllDishesWithType();
        if(dishesWithTypes == null){
            System.out.println("dishesWithTypes == null");
        }else{
            System.out.println("dishesWithTypes != null");
        }
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonObject.put("dishType",dishTypes);
        jsonObject1.put("dishes",dishesWithTypes);
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);
        System.out.println(jsonArray);
        ResponseWrite.writeJSON(response,jsonArray);
        return null;
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