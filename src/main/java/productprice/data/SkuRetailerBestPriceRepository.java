package productprice.data;

import org.springframework.data.repository.CrudRepository;

public interface SkuRetailerBestPriceRepository extends CrudRepository<SkuRetailerBestPrice, String> {

    SkuRetailerBestPrice findBySku(String sku);

}
