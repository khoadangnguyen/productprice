package productprice.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkuRetailerPriceRepository extends CrudRepository<SkuRetailerPrice, Long> {
    List<SkuRetailerPrice> findBySkuAndRetailerAndIsValid(String sku, String retailer, Boolean isValid);
    List<SkuRetailerPrice> findBySkuAndIsValidOrderByPriceAsc(String sku, Boolean isValid);
}
