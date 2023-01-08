package lifestyle.awardscore.domain.member.facade;

import lifestyle.awardscore.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberRepository memberRepository;

}
