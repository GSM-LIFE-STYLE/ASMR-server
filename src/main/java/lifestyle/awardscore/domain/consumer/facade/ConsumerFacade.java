package lifestyle.awardscore.domain.consumer.facade;

import lifestyle.awardscore.domain.consumer.entity.Consumer;
import lifestyle.awardscore.domain.consumer.exception.NotFoundConsumerException;
import lifestyle.awardscore.domain.consumer.exception.UnqualifiedMarketMemberException;
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

    public void verifyMarketConsumer(Consumer consumer, Market market){
        if(!consumer.getMarket().equals(market))
            throw new UnqualifiedMarketMemberException("상점 마켓 회원이 아닙니다.");
    }

    public Consumer findById(Long consumerId){
        return consumerRepository.findById(consumerId)
                .orElseThrow(() -> new NotFoundConsumerException("존재하지 않는 소비자입니다."));
    }

    public Consumer findByMember(Member member){
        return consumerRepository.findByMember(member)
                .orElseThrow(() -> new NotFoundConsumerException("존재하지 않는 소비자입니다."));
    }

    public void deleteByMarketAndMember(Member member, Market market){
        consumerRepository.deleteByMemberAndMarket(member, market);
    }
}
