package productprice.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="sku_retailer_price")
public class SkuRetailerPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    Long id;

    @Getter
    @Setter
    @Column(name="retailer")
    String retailer;

    @Getter
    @Setter
    @Column(name="sku")
    String sku;

    @Getter
    @Setter
    @Column(name="price")
    Double price;

    @Getter
    @Setter
    @Column(name="url")
    String url;

    @Getter
    @Setter
    @Column(name="created_at")
    Long createAt;

    @Getter
    @Setter
    @Column(name="is_valid")
    Boolean isValid;

    @Getter
    @Setter
    @Column(name="updated_at")
    Long updatedAt;

}
