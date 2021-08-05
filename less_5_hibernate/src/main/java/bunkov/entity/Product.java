//package bunkov.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "products")
//@NamedQueries({
//		@NamedQuery(name = "AllProducts", query = "select p from Product p"),
//		@NamedQuery(name = "CountOfProducts", query = "select count(p) from Product p")
//})
//public class Product {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@Column(length = 100,nullable = false)
//	private String name;
//
//	@Column(nullable = false)
//	private Integer cost;
//
//	public Product() {
//	}
//
////	public Product(String name){
////		this.name = name;
////	}
////	public Product(String name, Integer cost){
////		this.name = name;
////		this.cost = cost;
////	}
//
//	public Long getId() {
//		return id;
//	}
//
//	@Override
//	public String toString() {
//		return "Product{" +
//				"id=" + id +
//				", name='" + name + '\'' +
//				", cost=" + cost +
//				'}';
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Integer getCost(){
//		return cost;
//	}
//
//	public void setCost(Integer cost){
//		this.cost = cost;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Product(Long id, String name, Integer cost) {
//		this.id = id;
//		this.name = name;
//		this.cost = cost;
//	}
//}
