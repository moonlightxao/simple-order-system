package edu.njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDish {
    private int id;
    private int dishId;
    private int orderId;
    private int dishSizeId;
    private int dishTasteId;
    private float nowPrice;
    private int num;
    private int state;
    private String comment;
}
