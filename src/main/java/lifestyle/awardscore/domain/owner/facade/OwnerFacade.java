package lifestyle.awardscore.domain.owner.facade;

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
}
