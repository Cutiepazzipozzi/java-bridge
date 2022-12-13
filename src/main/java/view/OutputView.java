package view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(List<String> upMap, List<String> downMap) {
        String up = "[" + String.join("|", upMap) + "]";
        String down = "[" + String.join("|", downMap) + "]";
        System.out.println(up);
        System.out.println(down);
    }

    public void printResult(List<String> upMap, List<String> downMap, int count) {
        System.out.println("최종 게임 결과");
        this.printMap(upMap, downMap);
        System.out.println("\n 게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: " + count);
    }

    public void printFailResult(List<String> upMap, List<String> downMap, int count) {
        System.out.println("최종 게임 결과");
        this.printMap(upMap, downMap);
        System.out.println("\n 게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + count);
    }
}
