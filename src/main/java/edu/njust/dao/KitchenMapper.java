package edu.njust.dao;

import edu.njust.pojo.DishType;
import edu.njust.pojo.Kitchen;
import edu.njust.pojo.KitchenDishType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface KitchenMapper {
    /*返回所有的厨房终端*/
    List<Kitchen> allKitchens();

    /*根据编号查询厨房*/
    Kitchen getKitchenById(int id);

    /*新增一个厨房终端*/
    boolean addKitchen(Kitchen kitchen);

    /*删除一个厨房终端*/
    boolean deleteKitchenById(int id);

    /*根据厨房ID查询菜品类型*/
    List<KitchenDishType> getAllDishTypeById(int id);

    /*根据菜品类型查看能做这个的厨房编号*/
    List<KitchenDishType> getAllKitchenCanById(int id);
}
