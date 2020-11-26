package edu.njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private int id;
    private int tableId;
    private float totalPrice;
    private float packPrice;
    private float realPrice;
    private Date ordersTime;
    private Date settleTime;
    private int state;
    private String comment;
}
