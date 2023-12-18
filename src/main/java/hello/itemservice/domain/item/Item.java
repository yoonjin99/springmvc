package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data // 위험함. 필요한 것만 골라쓰는게 좋음
@Getter @Setter
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private int quantity;

    public Item() {}

    public Item(String itemName, Integer price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
