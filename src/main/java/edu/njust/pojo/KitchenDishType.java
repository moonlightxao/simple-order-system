package edu.njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KitchenDishType {
    private int id;
    private int kitchenId;
    private int dishTypeId;
}
