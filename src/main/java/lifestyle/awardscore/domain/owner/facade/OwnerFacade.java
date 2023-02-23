package lifestyle.awardscore.domain.owner.facade;

import lifestyle.awardscore.domain.market.exception.AlreadyMarketOwnerException;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.owner.entity.Owner;
import lifestyle.awardscore.domain.owner.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerFacade {
    private final OwnerRepository ownerRepository;

    public Owner saveOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public void existsByMember(Member member){
        if(ownerRepository.existsByMember(member))
            throw new AlreadyMarketOwnerException("이미 상점마켓 주인입니다.");
    }
}
