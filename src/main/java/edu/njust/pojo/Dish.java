package edu.njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private int id;
    private int dishTypeId;
    private String name;
    private float oldPrice;
    private float nowPrice;
    private String unit;
    private String detail;
    private int num;
    private int recommend;
    private String picUrl;
    private int state;
    private String comment;
}
