package lifestyle.awardscore.domain.auth.service;

import lifestyle.awardscore.domain.auth.entity.BlackList;
import lifestyle.awardscore.domain.auth.entity.RefreshToken;
import lifestyle.awardscore.domain.auth.exception.BlackListAlreadyExistException;
import lifestyle.awardscore.domain.auth.exception.NotFoundRefreshTokenException;
import lifestyle.awardscore.domain.auth.repository.BlackListRepository;
import lifestyle.awardscore.domain.auth.repository.RefreshTokenRepository;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.global.security.jwt.TokenProvider;
import lifestyle.awardscore.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberLogoutService {

    private final BlackListRepository blackListRepository;
    private final TokenProvider tokenProvider;
    private final MemberFacade memberFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    /**
     * 이메일과 엑세스 토큰을 받아 블랙리스트에 등록하는 서비스 로직
     * @param email
     * @param accessToken
     * @author 박주홍
     */
    private void saveBlackList(String email, String accessToken) {

        if(blackListRepository.existsById(accessToken))
            throw new BlackListAlreadyExistException("블랙리스트에 이미 등록되어있습니다.");

        long expiredTime = tokenProvider.getACCESS_TOKEN_EXPIRE_TIME();

        BlackList blackList = BlackList.builder()
                .email(email)
                .accessToken(accessToken)
                .timeToLive(expiredTime)
                .build();
        blackListRepository.save(blackList);
    }

    /**
     * 엑세스토큰을 받아 로그아웃 처리하는 서비스 로직
     * @param accessToken
     * @author 박주홍
     */
    @Transactional
    public void logout(String accessToken) {
        Member member = memberFacade.getCurrentMember();
        String email = member.getEmail();
        RefreshToken refreshToken = refreshTokenRepository.findById(email)
                .orElseThrow(() -> new NotFoundRefreshTokenException("존재하지 않는 리프레시 토큰입니다."));
        refreshTokenRepository.delete(refreshToken);
        saveBlackList(member.getEmail(), accessToken);
    }
}
