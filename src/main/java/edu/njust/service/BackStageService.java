package edu.njust.service;

import edu.njust.dao.*;
import edu.njust.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/*服务器后台的业务层
* 主要有登录业务
* 账单管理业务
* 餐桌管理业务
* 菜品维护业务
* */

@Service
public class BackStageService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private TableMapper tableMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    /*登录业务，返回1表示成功,0表示密码错误,-1表示账号不存在*/
    public int login(Admin admin){
        Admin res = adminMapper.login(admin.getUsr());
        if(res == null){
            return -1;
        }else if(res.getPwd().equals(admin.getPwd()) == false){
            return 0;
        }else return 1;
    }

    /*1.注册0表示已存在，1表示成功*/
    public int signUp(Admin admin){
        Admin res = adminMapper.getAdminByUsr(admin.getUsr());
        if(res == null){
            adminMapper.createAdmin(admin);
            return 1;
        }
        return 0;
    }

    /*2.修改账号业务*/
    public boolean updateAccount(Admin admin){
        return adminMapper.updateAdmin(admin);
    }

    /*3.根据用户名查询用户*/
    public Admin getAdminByUsr(String usr){
        return adminMapper.getAdminByUsr(usr);
    }


    /*菜品类型维护业务，主要负责菜品的增删改查*/
    /*1.查找所有的菜品类型*/
    public List<DishType> allDishType(){
        List<DishType> list = dishMapper.allDishType();
        if(list != null){
            for(DishType dishType : list){
                System.out.println(dishType);
            }
        }
        return list;
    }

    /*2.新增一个菜品类型*/
    public boolean addDishType(DishType type){
        return dishMapper.addDishType(type);
    }

    /*3.在某一菜品类型目录下新增一个菜品*/
    public boolean addDish(Dish dish){
        return dishMapper.addDish(dish);
    }

    /*4.返回该菜品类型下的所有的菜品*/
    public List<Dish> allDishByType(DishType type){
        if(type == null){
            return null;
        }
        return dishMapper.allDishByType(type.getId());
    }

    /*5.在某一菜品类型目录下删除一个菜品*/
    public boolean deleteDish(int id){
        return dishMapper.deleteDishById(id);
    }

    /*6.在某一菜品类型目录下更新一个菜品*/
    public boolean updateDish(Dish dish){
        return dishMapper.updateDish(dish);
    }

    /*7.根据菜品类型编号查询菜品*/
    public DishType getDishTypeById(int id){
        return dishMapper.getDishTypeById(id);
    }

    /*8.查询所有的菜品*/
    public List<Dish> getAllDishes(){
        return dishMapper.allDishes();
    }

    /*9.按照菜品类型查询所有的菜品*/
    public List<DishesWithType> getAllDishesWithType(){
        List<DishType> types = dishMapper.allDishType();
        List<DishesWithType> list = new LinkedList<>();
        for(DishType type:types){
            List<Dish> dishes = dishMapper.allDishByType(type.getId());
            DishesWithType dishesWithType = new DishesWithType(type,dishes);
            list.add(dishesWithType);
        }
        return list;
    }


    /*餐桌管理业务*/
    /*1.返回所有的餐桌信息*/
    public List<Tables> allTables(){
        return tableMapper.allTables();
    }

    /*2.按照编号查找一个餐桌信息*/
    public Tables findTableById(int id){
        return tableMapper.findTableById(id);
    }

    /*3.新增一个餐桌*/
    public boolean addNewTable(Tables tables){
        return tableMapper.addTables(tables);
    }

    /*4.根据编号删除一个餐桌*/
    public boolean deleteTableById(int id){
        return tableMapper.deleteTableById(id);
    }

    /*5.更新一个餐桌信息*/
    public boolean updateTable(Tables tables){
        return tableMapper.updateTable(tables);
    }

    /*账单管理业务*/
    /*1.查询所有的历史账单*/
    public List<Orders> historyOrders(){
        List<Orders> list = new LinkedList<>();
        for(Orders orders: ordersMapper.allOrders()){
            if(orders.getState() == 1){
                list.add(orders);
            }
        }
        return list;
    }

    /*2.查询还没结账的账单*/
    public List<Orders> allLivingOrders(){
        List<Orders> list = new LinkedList<>();
        for(Orders orders:ordersMapper.allOrders()){
            if(orders.getState() == 0){
                list.add(orders);
            }
        }
        return list;
    }


}
