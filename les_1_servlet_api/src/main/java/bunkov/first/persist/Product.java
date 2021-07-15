package bunkov.first.persist;

public class Product {
	private Long id;
	private String name;
	private Integer cost;

	public Product() {
	}

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

	public Product(Long id, String name, Integer cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
}
