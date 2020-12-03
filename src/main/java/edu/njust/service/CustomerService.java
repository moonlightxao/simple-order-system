package edu.njust.service;

import edu.njust.dao.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private OrdersMapper ordersMapper;


}
