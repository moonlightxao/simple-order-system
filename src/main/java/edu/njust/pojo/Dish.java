package edu.njust.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    @JSONField(name = "id", ordinal = 1)
    private int id;
    @JSONField(name = "dishtypeid", ordinal = 2)
    private int dishTypeId;
    @JSONField(name = "name", ordinal = 3)
    private String name;
    @JSONField(name = "oldPrice", ordinal = 4)
    private float oldPrice;
    @JSONField(name = "newPrice", ordinal = 5)
    private float nowPrice;
    @JSONField(name = "unit", ordinal = 6)
    private String unit;
    @JSONField(name = "detail", ordinal = 7)
    private String detail;
    private int num;
    @JSONField(name = "recommend", ordinal = 8)
    private int recommend;
    @JSONField(name = "picUrl", ordinal = 9)
    private String picUrl;
    private int state;
    private String comment;
}
