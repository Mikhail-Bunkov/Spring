package bunkov.homework.entity;

import javax.persistence.*;

@Entity
@Table(name = "products_homework")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer cost;

    @JoinColumn(name = "buyer_id")
    @ManyToOne
    private Buyer buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCost(){
        return cost;
    }

    public void setCost(Integer cost){
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(Long id, String name, Integer cost, Buyer buyer) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.buyer = buyer;
    }

    public Product() {
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", buyer=" + buyer.getName() +
                '}';
    }
}
