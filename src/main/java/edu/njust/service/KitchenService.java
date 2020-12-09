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
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private OrdersMapper ordersMapper;


    /*查询所有的菜品给厨房*/
    public Map<Integer, Dish> queryAllWaitingDish(){
        Map<Integer, Dish> map = new LinkedHashMap<>();
        List<OrdersDish> allList = ordersMapper.getAllOrderDish();
        for(OrdersDish ordersDish:allList){
            Dish dish = dishMapper.getDishById(ordersDish.getDishId());
            map.put(ordersDish.getId(),dish);
        }
        return map;
    }

    /*处理菜品完成请求*/
    public boolean completeDish(Integer id){
       return ordersMapper.updateOrderDish(1,id);
    }
}
