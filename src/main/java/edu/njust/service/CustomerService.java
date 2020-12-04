package edu.njust.service;

import edu.njust.dao.DishMapper;
import edu.njust.dao.KitchenMapper;
import edu.njust.dao.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private DishMapper dishMapper;

}
