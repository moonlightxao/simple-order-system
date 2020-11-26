package edu.njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tables {
    private int id;
    private String name;
    private int maxNum;
    private int leastCost;
    private int state;
    private String comment;
}
