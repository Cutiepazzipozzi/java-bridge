package View;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        System.out.println("다리 길이를 입력해주세요.");
        String size = "";
        try {
            size = Console.readLine();
            this.validBridgeSize(size);
        } catch (IllegalArgumentException message) {
            System.out.println(message);
            return this.readBridgeSize();
        }
        return Integer.parseInt(size);
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move = "";
        try {
            move = Console.readLine();
            this.validMoving(move);
        } catch (IllegalArgumentException message) {
            System.out.println(message);
            return this.readMoving();
        }
        return move;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할 지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = "";
        try {
            command = Console.readLine();
            this.validCommand(command);
        } catch (IllegalArgumentException message) {
            System.out.println(message);
            return this.readGameCommand();
        }
        return command;
    }

    public void validBridgeSize(String size) {
        if (Valid.isEmpty(size)) throw new IllegalArgumentException("[ERROR] 3-20 사이의 다리 길이를 입력해 주세요.");
        if (Valid.isLetter(size)) throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력해 주세요.");
        if (Valid.isNumberNotInRange(size)) throw new IllegalArgumentException("[ERROR] 3-20 사이의 숫자를 입력해 주세요. ");
    }

    public void validMoving(String move) {
        if (Valid.isEmpty(move)) throw new IllegalArgumentException("[ERROR] U or D 중 하나를 입력해 주세요.");
        if (Valid.isNumber(move)) throw new IllegalArgumentException("[ERROR] 문자 U or D 만 입력해 주세요.");
        if (Valid.isNotMoveLetter(move)) throw new IllegalArgumentException("[ERROR] U와 D만 입력 가능 합니다.");
    }

    public void validCommand(String command) {
        if (Valid.isEmpty(command)) throw new IllegalArgumentException("[ERROR] R or Q 중 하나를 입력해 주세요.");
        if (Valid.isNumber(command)) throw new IllegalArgumentException("[ERROR] 문자 R or Q 만 입력해 주세요.");
        if (Valid.isNotCommandLetter(command)) throw new IllegalArgumentException("[ERROR] R과 Q만 입력 가능 합니다.");
    }
}
