package productprice.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sku_retailer_best_price")
public class SkuRetailerBestPrice {

    @Getter
    @Setter
    @Id
    @Column(name="sku")
    String sku;

    @Getter
    @Setter
    @Column(name="retailer")
    String retailer;

    @Getter
    @Setter
    @Column(name="price")
    Double price;

    @Getter
    @Setter
    @Column(name="url")
    String url;
}
