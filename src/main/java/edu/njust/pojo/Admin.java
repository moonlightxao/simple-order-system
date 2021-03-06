package edu.njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/*管理员用户表对应的实体类*/

@Data
@NoArgsConstructor
@Component
public class Admin {
    private int id;
    private String name;
    private String usr;
    private String pwd;
    private String tel;

    public Admin(String name, String usr, String pwd, String tel){
        this.name = name;
        this.usr = usr;
        this.pwd = pwd;
        this.tel = tel;
    }

    public Admin(int id, String name, String usr, String pwd, String tel) {
        this.id = id;
        this.name = name;
        this.usr = usr;
        this.pwd = pwd;
        this.tel = tel;
    }
}
