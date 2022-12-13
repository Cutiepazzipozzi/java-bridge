package view;

public enum ValidMessage {

    sizeEmpty("[ERROR] 3-20 사이의 다리 길이를 입력해 주세요."),
    sizeNumber("[ERROR] 다리 길이는 숫자만 입력해 주세요."),
    sizeRange("[ERROR] 3-20 사이의 숫자를 입력해 주세요. "),
    moveEmpty("[ERROR] U or D 중 하나를 입력해 주세요."),
    moveLetter("[ERROR] 문자 U or D 만 입력해 주세요."),
    moveRange("[ERROR] U와 D만 입력 가능 합니다."),
    finishEmpty("[ERROR] R or Q 중 하나를 입력해 주세요."),
    finishLetter("[ERROR] 문자 R or Q 만 입력해 주세요."),
    finishRange("[ERROR] R과 Q만 입력 가능 합니다.");

    private final String message;

    private ValidMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
