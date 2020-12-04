package edu.njust.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishesWithType {
    @JSONField(name = "type", ordinal = 1)
    private DishType type;
    @JSONField(name = "dishList", ordinal = 2)
    private List<Dish> dishes;
}
