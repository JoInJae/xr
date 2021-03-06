package app.data.response.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Response {

    SUCCESS("0000", "성공"),

    FAIL_ID("0001", "잘못된 아이디"),
    FAIL_PASSWORD("0002", "잘못된 패스워드"),
    FAIL_ID_DUPLICATE("0003", "중복된 아이디"),
    WRONG_PASSWORD("0004", "잘못된 패스워드"),
    FAIL_TOKEN_NOT_EXIST("0005", "잘못된 토큰 양식"),
    FAIL_TOKEN_INVALID("0006", "유효하지 않은 토큰"),
    FAIL_TOKEN_TIMEOUT("0007", "유효 기간이 지난 토큰"),

    FAIL_PARAMETER("0010", "잘못된 파라미터"),

    WRONG_ENUM_CODE("0020", "잘못된 코드 값"),
    WRONG_ENUM_NAME("0021", "잘못된 이름 값"),
    
    ERROR_ENTITY("0101", "ENTITY 에러, 계속 문제가 발생하면 연락주세요"),
    ERROR_SQL("0102", "SQL 에러, 계속 문제가 발생하면 연락주세요");

    private final String status;
    private final String message;

}
