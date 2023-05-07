package productprice.service;

import productprice.data.SkuRetailerBestPrice;
import productprice.data.SkuRetailerBestPriceRepository;
import productprice.data.SkuRetailerPrice;
import productprice.data.SkuRetailerPriceRepository;
import productprice.dto.PriceDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SkuRetailerPriceService {

    @Autowired
    private SkuRetailerPriceRepository skuRetailerPriceRepository;

    @Autowired
    private SkuRetailerBestPriceRepository skuRetailerBestPriceRepository;

    @Transactional
    public SkuRetailerPrice save(SkuRetailerPrice skuRetailerPrice) {
        return skuRetailerPriceRepository.save(skuRetailerPrice);
    }

    public void updateSkuRetailerPrice(PriceDTO priceDTO) {
        List<SkuRetailerPrice> skuRetailerPriceList = skuRetailerPriceRepository
                .findBySkuAndRetailerAndIsValid(priceDTO.getSku(), priceDTO.getRetailer(), true);

        if (skuRetailerPriceList.size() > 0) {
            for (SkuRetailerPrice previusSkuRetailerPrice : skuRetailerPriceList) {
                previusSkuRetailerPrice.setIsValid(false);
                previusSkuRetailerPrice.setUpdatedAt((new Date()).getTime());
                skuRetailerPriceRepository.save(previusSkuRetailerPrice);
            }
        }

        SkuRetailerPrice skuRetailerPrice = new SkuRetailerPrice();
        skuRetailerPrice.setSku(priceDTO.getSku());
        skuRetailerPrice.setRetailer(priceDTO.getRetailer());
        skuRetailerPrice.setPrice(priceDTO.getPrice());
        skuRetailerPrice.setUrl(priceDTO.getUrl());
        skuRetailerPrice.setIsValid(true);
        skuRetailerPrice.setCreateAt((new Date()).getTime());
        skuRetailerPrice.setUpdatedAt(null);
        skuRetailerPriceRepository.save(skuRetailerPrice);

        List<SkuRetailerPrice> skuRetailerPriceOrderList = skuRetailerPriceRepository
                .findBySkuAndIsValidOrderByPriceAsc(priceDTO.getSku(), true);

        SkuRetailerBestPrice skuRetailerBestPrice = new SkuRetailerBestPrice();
        skuRetailerBestPrice.setSku(skuRetailerPriceOrderList.get(0).getSku());
        skuRetailerBestPrice.setRetailer(skuRetailerPriceOrderList.get(0).getRetailer());
        skuRetailerBestPrice.setPrice(skuRetailerPriceOrderList.get(0).getPrice());
        skuRetailerBestPrice.setUrl(skuRetailerPriceOrderList.get(0).getUrl());
        skuRetailerBestPriceRepository.save(skuRetailerBestPrice);
    }

    public PriceDTO findPrice(String sku) {
        SkuRetailerBestPrice skuRetailerBestPrice = skuRetailerBestPriceRepository.findBySku(sku);

        if (skuRetailerBestPrice == null) {
            return null;
        }
        else {
            return new PriceDTO(
                    skuRetailerBestPrice.getRetailer(),
                    skuRetailerBestPrice.getSku(),
                    skuRetailerBestPrice.getPrice(),
                    skuRetailerBestPrice.getUrl()
            );
        }
    }

}
