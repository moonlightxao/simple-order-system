package edu.njust.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishType {
    @JSONField(name = "id", ordinal = 1)
    private int id;
    @JSONField(name = "name", ordinal = 2)
    private String name;
}
