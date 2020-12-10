package edu.njust.service;


import edu.njust.dao.DishMapper;
import edu.njust.dao.KitchenMapper;
import edu.njust.dao.OrdersMapper;
import edu.njust.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KitchenService {
    /*在这个demo预设只有一个厨房对所有菜品进行处理(不处理多线程情况)*/
    private static List<OrderDishId> allList = new LinkedList<>();

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    /*对所有的菜品分发给不同的厨房处理*/
    public Map<Integer, Dish> deliver(int orderId){
        List<OrdersDish> ordersDishes = ordersMapper.getAllOrdersDishById(orderId);
        Map<Integer, Dish> map = new LinkedHashMap<>();
        for(OrdersDish tmp: ordersDishes){
            Dish dish = dishMapper.getDishById(tmp.getDishId());
            allList.add(new OrderDishId(tmp.getId(), dish));
            map.put(tmp.getId(), dish);
        }
        return map;
    }

    /*查询所有的菜品给厨房*/
    public Map<Integer, Dish> queryAllWaitingDish(){
        Map<Integer, Dish> map = new LinkedHashMap<>();
        for(OrderDishId orderDishId: allList){
            map.put(orderDishId.getId(), orderDishId.getDish());
        }
        return map;
    }

    /*处理菜品完成请求*/
    public Map<Integer, Dish> completeDish(Integer id){
        ordersMapper.updateOrderDish(1,id);
        return this.queryAllWaitingDish();
    }
}
