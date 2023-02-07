package lifestyle.awardscore.domain.auth.service;

import lifestyle.awardscore.domain.auth.entity.BlackList;
import lifestyle.awardscore.domain.auth.exception.BlackListAlreadyExistException;
import lifestyle.awardscore.domain.auth.repository.BlackListRepository;
import lifestyle.awardscore.global.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberLogoutService {

    private final BlackListRepository blackListRepository;
    private final TokenProvider tokenProvider;

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
}
