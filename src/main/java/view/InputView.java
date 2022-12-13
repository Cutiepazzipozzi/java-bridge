package view;

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
        if (Valid.isEmpty(size)) throw new IllegalArgumentException(ValidMessage.sizeEmpty.getMessage());
        if (Valid.isLetter(size)) throw new IllegalArgumentException(ValidMessage.sizeNumber.getMessage());
        if (Valid.isNumberNotInRange(size)) throw new IllegalArgumentException(ValidMessage.sizeRange.getMessage());
    }

    public void validMoving(String move) {
        if (Valid.isEmpty(move)) throw new IllegalArgumentException(ValidMessage.moveEmpty.getMessage());
        if (Valid.isNumber(move)) throw new IllegalArgumentException(ValidMessage.moveLetter.getMessage());
        if (Valid.isNotMoveLetter(move)) throw new IllegalArgumentException(ValidMessage.moveRange.getMessage());
    }

    public void validCommand(String command) {
        if (Valid.isEmpty(command)) throw new IllegalArgumentException(ValidMessage.finishEmpty.getMessage());
        if (Valid.isNumber(command)) throw new IllegalArgumentException(ValidMessage.finishLetter.getMessage());
        if (Valid.isNotCommandLetter(command)) throw new IllegalArgumentException(ValidMessage.finishRange.getMessage());
    }
}
