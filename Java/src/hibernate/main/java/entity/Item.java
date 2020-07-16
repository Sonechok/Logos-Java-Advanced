package entity;

import java.util.Set;

public class Item {
    private Integer id;

    private Integer total;

    private Set<Cart> cartSet;

    public Item(Integer total) {
        this.total = total;
    }

    public Item() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Set<Cart> getCartSet() {
        return cartSet;
    }

    public void setCartSet(Set<Cart> cartSet) {
        this.cartSet = cartSet;
    }
}
