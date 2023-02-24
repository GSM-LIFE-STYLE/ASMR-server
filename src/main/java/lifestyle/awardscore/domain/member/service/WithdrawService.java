package lifestyle.awardscore.domain.member.service;

import lifestyle.awardscore.domain.auth.entity.RefreshToken;
import lifestyle.awardscore.domain.auth.exception.NotFoundRefreshTokenException;
import lifestyle.awardscore.domain.auth.repository.RefreshTokenRepository;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WithdrawService {

    private final MemberFacade memberFacade;
    private final MemberRepository memberRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    /**
     * 회원탈퇴 기능의 서비스 로직
     * @param password
     * @author 김희망
     */
    @Transactional
    public void execute(String password) {
        Member member = memberFacade.getCurrentMember();
        RefreshToken refreshToken = refreshTokenRepository.findById(member.getEmail())
                .orElseThrow(() -> new NotFoundRefreshTokenException("존재하지 않는 리프레시 토큰입니다."));

        memberFacade.checkPassword(member, password);

        refreshTokenRepository.delete(refreshToken);
        memberRepository.delete(member);
    }
}
