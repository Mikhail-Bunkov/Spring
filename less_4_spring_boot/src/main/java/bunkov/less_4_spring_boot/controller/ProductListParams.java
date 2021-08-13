package bunkov.less_4_spring_boot.controller;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class ProductListParams {

    private String productNameFilter;
    private Integer productMinCostFilter;
    private Integer productMaxCostFilter;
    private Integer page;
    private Integer size;
    private String sortField;

    public String getProductNameFilter() {
        return productNameFilter;
    }

    public void setProductNameFilter(String productNameFilter) {
        this.productNameFilter = productNameFilter;
    }

    public Integer getProductMinCostFilter() {
        return productMinCostFilter;
    }

    public void setProductMinCostFilter(Integer productMinCostFilter) {
        this.productMinCostFilter = productMinCostFilter;
    }

    public Integer getProductMaxCostFilter() {
        return productMaxCostFilter;
    }

    public void setProductMaxCostFilter(Integer productMaxCostFilter) {
        this.productMaxCostFilter = productMaxCostFilter;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }
}
