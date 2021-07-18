package bunkov.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class ProductRepositoryImp implements ProductRepository {

	private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

	private final AtomicLong identity = new AtomicLong(0);

	@PostConstruct
	public void init() {
		this.save(new Product("apple",100));
		this.save(new Product("orange",200));
		this.save(new Product("strawberry",120));
	}

	@Override
	public List<Product> findAll(){
		return new ArrayList<>(productMap.values());
	}

	@Override
	public Product findById(long id){
		return productMap.get(id);
	}

	@Override
	public void save(Product product){
		if(product.getId()==null) {
			long id = identity.incrementAndGet();
			product.setId(id);
		}
		productMap.put(product.getId(), product);
	}

	@Override
	public void delete(long id){
		identity.decrementAndGet();
		productMap.remove(id);
	}
}
