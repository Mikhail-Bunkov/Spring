package bunkov.less_4_spring_boot.persist;

public class Product {
	private Long id;
//	@NotBlank
	private String name;

//	@Min(value = 100)
//	@Max(value = 10000)
	private Integer cost;

	public Product() {
	}

	public Product(String name){
		this.name = name;
	}
	public Product(String name, Integer cost){
		this.name = name;
		this.cost = cost;
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
