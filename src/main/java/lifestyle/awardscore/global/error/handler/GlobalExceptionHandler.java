package lifestyle.awardscore.global.error.handler;

import lifestyle.awardscore.domain.auth.exception.ExistEmailException;
import lifestyle.awardscore.domain.auth.exception.NotFoundRefreshTokenException;
import lifestyle.awardscore.domain.auth.exception.NotVerifyEmailException;
import lifestyle.awardscore.domain.consumer.exception.NotFoundConsumerException;
import lifestyle.awardscore.domain.consumer.exception.UnqualifiedMarketMemberException;
import lifestyle.awardscore.domain.email.exception.AuthCodeExpiredException;
import lifestyle.awardscore.domain.email.exception.ManyRequestEmailAuthException;
import lifestyle.awardscore.domain.email.exception.MisMatchAuthCodeException;
import lifestyle.awardscore.domain.item.exception.ForbiddenAccessItemException;
import lifestyle.awardscore.domain.item.exception.NotFoundItemException;
import lifestyle.awardscore.domain.market.exception.AlreadyRegisterMarketException;
import lifestyle.awardscore.domain.market.exception.NotFoundMarketException;
import lifestyle.awardscore.domain.market.exception.UnqualifiedMarketOwnerException;
import lifestyle.awardscore.domain.member.exception.MemberNotFoundException;
import lifestyle.awardscore.domain.notice.exception.NotFoundNoticeException;
import lifestyle.awardscore.domain.notice.exception.UnqualifiedNoticeWriterException;
import lifestyle.awardscore.global.error.ErrorMessage;
import lifestyle.awardscore.global.security.exception.TokenExpirationException;
import lifestyle.awardscore.global.security.exception.TokenNotValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleMemberNotFoundException(HttpServletRequest request , MemberNotFoundException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ExistEmailException.class)
    public ResponseEntity<ErrorMessage> handleExistEmailException(HttpServletRequest request , ExistEmailException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotVerifyEmailException.class)
    public ResponseEntity<ErrorMessage> handleNotVerifyEmailException(HttpServletRequest request , NotVerifyEmailException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenExpirationException.class)
    public ResponseEntity<ErrorMessage> handleTokenExpirationException(HttpServletRequest request , TokenExpirationException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<ErrorMessage> handleTokenNotValidException(HttpServletRequest request , TokenNotValidException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(AuthCodeExpiredException.class)
    public ResponseEntity<ErrorMessage> handleAuthCodeExpiredException(HttpServletRequest request , AuthCodeExpiredException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ManyRequestEmailAuthException.class)
    public ResponseEntity<ErrorMessage> handleManyRequestEmailAuthException(HttpServletRequest request , ManyRequestEmailAuthException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MisMatchAuthCodeException.class)
    public ResponseEntity<ErrorMessage> handleMisMatchAuthCodeException(HttpServletRequest request , MisMatchAuthCodeException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotFoundRefreshTokenException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundRefreshTokenException(HttpServletRequest request , NotFoundRefreshTokenException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(UnqualifiedMarketOwnerException.class)
    public ResponseEntity<ErrorMessage> handleUnqualifiedMarketOwnerException(HttpServletRequest request , UnqualifiedMarketOwnerException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotFoundItemException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundItemException(HttpServletRequest request , NotFoundItemException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ForbiddenAccessItemException.class)
    public ResponseEntity<ErrorMessage> handleForbiddenAccessItemException(HttpServletRequest request , ForbiddenAccessItemException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotFoundMarketException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundMarketException(HttpServletRequest request , NotFoundMarketException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(UnqualifiedNoticeWriterException.class)
    public ResponseEntity<ErrorMessage> handleUnqualifiedNoticeWriterException(HttpServletRequest request , UnqualifiedNoticeWriterException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotFoundNoticeException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundNoticeException(HttpServletRequest request , NotFoundNoticeException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotFoundConsumerException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundConsumerException(HttpServletRequest request , NotFoundConsumerException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(UnqualifiedMarketMemberException.class)
    public ResponseEntity<ErrorMessage> handleUnqualifiedMarketMemberException(HttpServletRequest request , UnqualifiedMarketMemberException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(AlreadyRegisterMarketException.class)
    public ResponseEntity<ErrorMessage> handleAlreadyRegisterMarketException(HttpServletRequest request , AlreadyRegisterMarketException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }


    private void printError(HttpServletRequest request, RuntimeException ex, String message) {
        log.error(request.getRequestURI());
        log.error(message);
        ex.printStackTrace();
    }
}
