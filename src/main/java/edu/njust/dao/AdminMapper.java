package edu.njust.dao;

import edu.njust.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMapper {
    Admin login(String usr);

    boolean createAdmin(Admin admin);

    boolean updateAdmin(Admin admin);

    Admin getAdminByUsr(String usr);

}
