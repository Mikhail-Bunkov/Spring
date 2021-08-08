package bunkov.less_4_spring_boot.persist;

import org.springframework.data.jpa.domain.Specification;

public final class ProductSpecifications {

    public static Specification<Product> productNamePrefix(String prefix){
        return (root, query, builder) -> builder.like(root.get("name"), prefix + "%");
    }

    public static  Specification<Product> minCost(int minCost){
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("cost"), minCost);  //ge()
    }


    public static  Specification<Product> maxCost(int maxCost){
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("cost"), maxCost);  //le()
    }
}
