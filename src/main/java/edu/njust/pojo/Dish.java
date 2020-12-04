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
    @JSONField(name = "recommed", ordinal = 8)
    private int recommend;
    @JSONField(name = "picUrl", ordinal = 9)
    private String picUrl;
    private int state;
    private String comment;
    private List<String> size;
    private List<String> taste;

    public Dish(int id, int dishTypeId, String name, float oldPrice, float nowPrice, String unit, String detail, int num, int recommend, String picUrl, int state, String comment) {
        this.id = id;
        this.dishTypeId = dishTypeId;
        this.name = name;
        this.oldPrice = oldPrice;
        this.nowPrice = nowPrice;
        this.unit = unit;
        this.detail = detail;
        this.num = num;
        this.recommend = recommend;
        this.picUrl = picUrl;
        this.state = state;
        this.comment = comment;
    }
}
