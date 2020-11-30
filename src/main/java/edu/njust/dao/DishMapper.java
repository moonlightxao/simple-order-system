package edu.njust.dao;

import edu.njust.pojo.Dish;
import edu.njust.pojo.DishSize;
import edu.njust.pojo.DishTaste;
import edu.njust.pojo.DishType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DishMapper {
    /*查询所有的菜品*/
    List<Dish> allDishes();

    /*根据菜品类型查找该类型下所有的菜品*/
    List<Dish> allDishByType(@Param("id") int typeId);

    /*添加一道菜品*/
    boolean addDish(Dish dish);

    /*删除一道菜品*/
    boolean deleteDishById(int id);

    /*更新一道菜品*/
    boolean updateDish(Dish dish);

    /*根据编号查询一道菜品*/
    Dish getDishById(int id);

    /*添加一个菜品大小记录*/
    boolean addDishSize(DishSize size);

    /*根据编号查找一个菜品大小*/
    DishSize getDishSizeById(int id);

    /*删除一个菜品大小记录*/
    boolean deleteDishSizeById(int id);

    /*添加一个菜品口味记录*/
    boolean addDishTaste(DishTaste taste);

    /*根据编号查找一个菜品口味*/
    DishTaste getDishTasteById(int id);

    /*删除一个菜品口味记录*/
    boolean deleteDishTasteById(int id);

    /*查找所有的菜品类型*/
    List<DishType> allDishType();

    /*根据编号查找一个菜品类型*/
    DishType getDishTypeById(int id);

    /*根据名称查找一个菜品类型*/
    DishType getDishTypeByName(String name);

    /*新增一个菜品类型*/
    boolean addDishType(DishType type);

    /*删除一个菜品类型*/
    boolean deleteDishTypeById(int id);
}
