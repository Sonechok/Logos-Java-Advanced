package entity;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cart {

    private Integer id;

    private Integer total;

    private String name;

    private Set<Item> itemSet = new HashSet<Item>();

    public Cart() {
    }

    public Cart(Integer total, String name) {
        this.total = total;
        this.name = name;
    }

    public boolean addItem(Item item){
        return this.itemSet.add(item);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<Item> itemSet) {
        this.itemSet = itemSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id.equals(cart.id) &&
                Objects.equals(total, cart.total) &&
                Objects.equals(name, cart.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, name);
    }
}
