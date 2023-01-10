package lifestyle.awardscore.domain.auth.service;

import lifestyle.awardscore.domain.auth.entity.RefreshToken;
import lifestyle.awardscore.domain.auth.presentation.dto.request.MemberLoginRequest;
import lifestyle.awardscore.domain.auth.presentation.dto.response.TokenResponse;
import lifestyle.awardscore.domain.auth.repository.RefreshTokenRepository;
import lifestyle.awardscore.domain.member.entity.Member;
import lifestyle.awardscore.domain.member.exception.MemberNotFoundException;
import lifestyle.awardscore.domain.member.facade.MemberFacade;
import lifestyle.awardscore.domain.member.repository.MemberRepository;
import lifestyle.awardscore.global.security.jwt.TokenProvider;
import lifestyle.awardscore.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberLoginService {

    private final MemberRepository memberRepository;
    private final MemberFacade memberFacade;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    @Transactional(rollbackFor = Exception.class)
    public TokenResponse login(MemberLoginRequest loginRequest) {
        Member member = memberFacade.getMemberByEmail(loginRequest.getEmail());

        memberFacade.checkPassword(member, loginRequest.getPassword());

        String accessToken = tokenProvider.generatedAccessToken(loginRequest.getEmail());
        String refreshToken = tokenProvider.generatedRefreshToken(loginRequest.getEmail());
        RefreshToken entityToRedis = new RefreshToken(loginRequest.getEmail(), refreshToken, tokenProvider.getREFRESH_TOKEN_EXPIRE_TIME());
        refreshTokenRepository.save(entityToRedis);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(tokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret()))
                .build();
    }
}
