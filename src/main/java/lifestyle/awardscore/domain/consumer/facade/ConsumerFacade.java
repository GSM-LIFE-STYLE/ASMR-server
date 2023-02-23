package lifestyle.awardscore.domain.consumer.facade;

import lifestyle.awardscore.domain.consumer.entity.Consumer;
import lifestyle.awardscore.domain.consumer.repository.ConsumerRepository;
import lifestyle.awardscore.domain.market.entity.Market;
import lifestyle.awardscore.domain.market.exception.AlreadyRegisterMarketException;
import lifestyle.awardscore.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumerFacade {

    private final ConsumerRepository consumerRepository;

    public Consumer saveConsumer(Consumer consumer){
        return consumerRepository.save(consumer);
    }

    public void existsByMember(Member member){
        if(consumerRepository.existsByMember(member))
            throw new AlreadyRegisterMarketException("이미 마켓에 가입된 유저입니다.");
    }

    public void deleteAllByMarket(Market market){
        consumerRepository.deleteAllByMarket(market);
    }
}
