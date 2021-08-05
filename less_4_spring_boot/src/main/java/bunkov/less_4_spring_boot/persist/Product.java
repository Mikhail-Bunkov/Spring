package bunkov.less_4_spring_boot.persist;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String name;

	@Min(value = 100)
	@Max(value = 10000)
	@NotBlank
	@Column(nullable = false)
	private BigDecimal cost;

	public Product() {
	}

	public Product(String name){
		this.name = name;
	}
	public Product(String name, BigDecimal cost){
		this.name = name;
		this.cost = cost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCost(){
		return cost;
	}
	public void setCost(BigDecimal cost){
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product(Long id, String name, BigDecimal cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
}
