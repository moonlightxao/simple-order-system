package edu.njust.dao;

import edu.njust.pojo.Orders;
import edu.njust.pojo.OrdersDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrdersMapper {
    /*返回所有的订单*/
    List<Orders> allOrders();

    /*根据订单编号查询一个订单*/
    Orders getOrderById(int id);

    /*新建一个订单*/
    boolean addNewOrder(Orders order);

    /*更新一个订单的价格*/
    boolean updateOrderPrice(Orders orders);

    boolean updateOrderState(int id);

    /*删除一个订单*/
    boolean deleteOrderById(int id);

    /*根据订单编号查询所有相关联的菜品*/
    List<OrdersDish> getAllOrdersDishById(int id);

    /*根据菜品编号查询所有相关联的菜品*/
    List<OrdersDish> getAllOrdersDishByDishId(int id);
    /*查询所有相关联的菜品*/
    List<OrdersDish> getAllOrderDish();

    /*根据订单编号和菜品编号删除一个关联记录*/
    boolean deleteOrdersDishById(@Param("did") int dId, @Param("oid") int oId);

    /*添加一个订单菜品记录*/
    boolean addOrdersDish(OrdersDish ordersDish);

    /*查找一个OrderDish*/
    OrdersDish getOrderDish(int id);

    /*更新一个OrderDish状态*/
    boolean updateOrderDish(@Param("state") int state, @Param("id") int id);

    /*根据桌号查找当前的一个活订单*/
    Orders getNowOrderByTableId(@Param("id") int tableId);
}
