package edu.njust.service;


import edu.njust.dao.DishMapper;
import edu.njust.dao.KitchenMapper;
import edu.njust.pojo.Dish;
import edu.njust.pojo.DishType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@Service
public class KitchenService {
    /*用厨房编号和其需要做的菜品的队列进行绑定*/
    private static Map<Integer, Queue<DishType>> map = new HashMap<>();

    @Autowired
    private KitchenMapper kitchenMapper;

    @Autowired
    private DishMapper dishMapper;

    /*对所有的菜品分发给不同的厨房处理*/
    public void deliver(String numOfDish){
        //对菜品编号进行分隔
    }
}
