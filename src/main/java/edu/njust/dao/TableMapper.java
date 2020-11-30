package edu.njust.dao;

import edu.njust.pojo.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TableMapper {
    /*返回所有的餐桌*/
    List<Tables> allTables();

    /*根据餐桌编号得到餐桌的状态*/
    int getTableState(int id);

    /*更新餐桌的状态*/
    boolean updateTable(Tables tables);

    /*新增餐桌*/
    boolean addTables(Tables tables);

    /*根据编号查找餐桌*/
    Tables findTableById(int id);

    /*删除一张餐桌*/
    boolean deleteTableById(int id);
}
