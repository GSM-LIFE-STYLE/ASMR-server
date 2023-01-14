package lifestyle.awardscore.domain.shop.service;

import lifestyle.awardscore.domain.shop.facade.ShopFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterShopService {

    private final ShopFacade shopFacade;

    @Transactional(rollbackFor = Exception.class)
    public void execute() {

    }
}
