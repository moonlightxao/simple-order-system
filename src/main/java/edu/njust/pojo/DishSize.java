package edu.njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishSize {
    private int id;
    private int dishId;
    private String name;
    private float oldPrice;
    private float nowPrice;
}
