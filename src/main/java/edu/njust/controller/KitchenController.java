package edu.njust.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.njust.pojo.Dish;
import edu.njust.service.KitchenService;
import edu.njust.utils.ResponseWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {
    @Autowired
    private KitchenService service;

    /*处理刷新页面时获得所有的待处理菜品数据*/
    @RequestMapping("/allDish")
    @CrossOrigin
    public String allDish(HttpServletResponse response) throws IOException {
        Map<Integer, Dish> map = service.queryAllWaitingDish();
        JSONArray array = new JSONArray();
        for(Map.Entry<Integer, Dish> entry: map.entrySet()){
            System.out.println("key = " + entry.getKey() + " , value = " + entry.getValue());
            JSONObject object = new JSONObject();
            object.put("id",entry.getKey());
            object.put("dish",entry.getValue());
            array.add(object);
        }
        ResponseWrite.writeJSON(response, array);
        return null;
    }

    /*处理完成某个菜品的请求*/
    @RequestMapping("/finish")
    @CrossOrigin
    public String finishDish(@RequestBody JSONObject jsonObject, HttpServletResponse response) throws IOException {
        String tmp = jsonObject.getString("id");
        Integer orderDishId = Integer.parseInt(tmp);
        System.out.println(orderDishId);
        Map<Integer, Dish> map = service.completeDish(orderDishId);
        JSONArray array = new JSONArray();
        for(Map.Entry<Integer, Dish> entry: map.entrySet()){
            System.out.println("key = " + entry.getKey() + " , value = " + entry.getValue());
            JSONObject object = new JSONObject();
            object.put("id",entry.getKey());
            object.put("dish",entry.getValue());
            array.add(object);
        }
        ResponseWrite.writeJSON(response, array);
        return null;
    }

}
