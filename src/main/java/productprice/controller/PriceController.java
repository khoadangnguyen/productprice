package productprice.controller;

import productprice.dto.PriceDTO;
import productprice.service.SkuRetailerPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PriceController {

    @Autowired
    SkuRetailerPriceService skuRetailerPriceService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }


    @PostMapping("/receive")
    public void receive(@RequestBody PriceDTO priceDt) {
        skuRetailerPriceService.updateSkuRetailerPrice(priceDt);
    }

    @GetMapping("/findPrice/{sku}")
    public ResponseEntity<PriceDTO> findPrice(@PathVariable String sku) {
        PriceDTO priceDTO = skuRetailerPriceService.findPrice(sku);
        return ResponseEntity.ok().body(priceDTO);
    }
}
