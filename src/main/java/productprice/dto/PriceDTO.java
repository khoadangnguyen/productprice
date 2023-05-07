package productprice.dto;

import lombok.Getter;
import lombok.Setter;

public class PriceDTO {

    @Getter
    @Setter
    String retailer;
    @Getter
    @Setter
    String sku;

    @Getter
    @Setter
    Double price;

    @Getter
    @Setter
    String url;

    public PriceDTO() {
        this.retailer = null;
        this.sku = null;
        this.price = null;
        this.url = null;
    }

    public PriceDTO(String retailer, String sku, Double price, String url) {
        this.retailer = retailer;
        this.sku = sku;
        this.price = price;
        this.url = url;
    }

}
