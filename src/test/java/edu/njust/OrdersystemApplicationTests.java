package edu.njust;

import edu.njust.dao.*;
import edu.njust.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class OrdersystemApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private TableMapper tableMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private KitchenMapper kitchenMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    void testAdminMapper(){
        Admin admin = new Admin(1,"罗翔","admin","54321","111");
        adminMapper.updateAdmin(admin);
    }

    @Test
    void testTablesMapper(){
        List<Tables> list = tableMapper.allTables();
        for(Tables tables : list){
            System.out.println(tables);
            System.out.println(tableMapper.getTableState(tables.getId()));
        }
        Tables t = list.get(0);
        t.setState(1);
        tableMapper.updateTable(t);
    }

    @Test
    void testOrdersMapper(){
        List<Orders> list = ordersMapper.allOrders();
        for(Orders order: list){
            System.out.println(order);
        }
        Orders o = ordersMapper.getOrderById(0);
        System.out.println("根据编号查询");
        System.out.println(o);
        o.setComment("修改过后");
        ordersMapper.addNewOrder(o);
        System.out.println("删除之前再查询全部账单");
        list = ordersMapper.allOrders();
        for(Orders order: list){
            System.out.println(order);
        }
        ordersMapper.deleteOrderById(2);
    }

    @Test
    void testDishMapper(){
        List<Dish> list = dishMapper.allDishes();
        for(Dish dish : list){
            System.out.println(dish);
        }
        System.out.println("通过ID查询Dish" + dishMapper.getDishById(1));
        Dish d = dishMapper.getDishById(1);
        d.setComment("来自夏一可家的冷吃兔肉奥利给！");
        dishMapper.addDish(d);
        System.out.println("添加了一个菜品");
        list = dishMapper.allDishes();
        for(Dish dish : list){
            System.out.println(dish);
        }
        d = dishMapper.getDishById(1);
        d.setComment("冷吃兔好吃但是别上头");
        dishMapper.updateDish(d);
    }


    @Test
    void testDishTasteAndSize(){
        System.out.println(dishMapper.getDishSizeById(2));
        System.out.println(dishMapper.getDishTasteById(2));
    }

    @Test
    void testOrderDish(){
        List<OrdersDish> list = ordersMapper.getAllOrdersDishById(1);
        for(OrdersDish ordersDish: list){
            System.out.println(ordersDish);
        }
    }

    @Test
    void testKitchen(){
        kitchenMapper.addKitchen(new Kitchen(0,"汉堡部门"));
        List<Kitchen> list = kitchenMapper.allKitchens();
        for(Kitchen kitchen:list) {
            System.out.println(kitchen);
        }
    }

}
