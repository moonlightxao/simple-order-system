package edu.njust.service;

import edu.njust.dao.DishMapper;
import edu.njust.dao.KitchenMapper;
import edu.njust.dao.OrdersMapper;
import edu.njust.dao.TableMapper;
import edu.njust.pojo.Dish;
import edu.njust.pojo.Orders;
import edu.njust.pojo.OrdersDish;
import edu.njust.pojo.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private TableMapper tableMapper;

    /*处理点餐请求
    * 生成账单
    * 返回订单编号
    * orderId = -1 wu zhangdan
    * */
    public int order(List<Dish> list, float totalPrice, int tableId, int orderId){
        Orders curOrder = null;
        if(orderId == -1){
            curOrder = new Orders(tableId, totalPrice, totalPrice, new Date(), null, 0, "null");
            ordersMapper.addNewOrder(curOrder);
            curOrder = ordersMapper.getNowOrderByTableId(tableId);
            Tables table = tableMapper.findTableById(tableId);
            table.setState(1);
            tableMapper.updateTable(table);
        }else{
            curOrder = ordersMapper.getOrderById(orderId);
        }
        float sumPrice = curOrder.getRealPrice();
        for(Dish dish:list){
            OrdersDish ordersDish = new OrdersDish(0, dish.getId(), curOrder.getId(),1,1,dish.getNowPrice(),1,0,dish.getComment());
            ordersMapper.addOrdersDish(ordersDish);
            dish.setNum(dish.getNum() - 1);
            dishMapper.updateDish(dish);
            sumPrice += dish.getNowPrice();
        }
        curOrder.setRealPrice(sumPrice);
        ordersMapper.updateOrderPrice(curOrder);
        return curOrder.getId();
    }
}
