package lifestyle.awardscore.domain.shop.facade;

import lifestyle.awardscore.domain.shop.entity.Shop;
import lifestyle.awardscore.domain.shop.exception.NotFoundShopException;
import lifestyle.awardscore.domain.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShopFacade {

    private final ShopRepository shopRepository;

    public Shop getShopEntityById(Long shopId) {
        return shopRepository.findById(shopId)
                .orElseThrow(() -> new NotFoundShopException("등록되지 않은 상점마켓입니다."));
    }

    public void saveShopEntity(Shop shop) {
        shopRepository.save(shop);
    }

    public void deleteShopEntityById(Long shopId) {
        shopRepository.deleteById(shopId);
    }
}
