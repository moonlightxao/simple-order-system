package edu.njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
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

    public Orders(int tableId, float totalPrice, float packPrice, Date ordersTime, Date settleTime, int state, String comment) {
        this.tableId = tableId;
        this.totalPrice = totalPrice;
        this.packPrice = packPrice;
        this.ordersTime = ordersTime;
        this.settleTime = settleTime;
        this.state = state;
        this.comment = comment;
        this.realPrice = totalPrice + packPrice;
    }
}
