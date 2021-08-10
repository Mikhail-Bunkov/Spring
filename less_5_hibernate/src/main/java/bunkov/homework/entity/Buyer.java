package bunkov.homework.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String name;

    @OneToMany(mappedBy = "buyer")
    private List<LineItem> lineItems = new ArrayList<>();

//    @ManyToMany(mappedBy = "buyers")
//    private List<Product> productList = new ArrayList<>();

    public Buyer() {
    }

    public Buyer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Product> getProductList() {
//        return productList;
//    }

//    public void setProductList(List<Product> productList) {
//        this.productList = productList;

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> products) {
        this.lineItems = products;
    }
//    }

//    public void addProduct(Product product){
//        product.setBuyers(List.of(this));
//        productList.add(product);
//    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
