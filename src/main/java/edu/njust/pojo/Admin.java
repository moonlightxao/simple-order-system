package edu.njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/*管理员用户表对应的实体类*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Admin {
    private int id;
    private String name;
    private String usr;
    private String pwd;
    private String tel;
}
