package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    private final List<String> answerBridge;

    private final List<String> upMap;

    private final List<String> downMap;

    private int count;

    private int index;

    public BridgeGame(int size) {
        this.answerBridge = bridgeMaker.makeBridge(size);
        this.upMap = new ArrayList<>();
        this.downMap = new ArrayList<>();
        this.count = 1;
        this.index = 0;
    }

    public List<String> getUpMap() {
        return this.upMap;
    }

    public List<String> getDownMap() {
        return this.downMap;
    }

    public int getCount() {
        return this.count;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isSameValue(String input) {
        return answerBridge.get(index).equals(input);
    }

    public void drawSuccessMap(String input) {
        if (input.equals("U")) {
            this.upMap.add(" O ");
            this.downMap.add("   ");
            return;
        }
        this.upMap.add("   ");
        this.downMap.add(" O ");
    }

    public void drawFailMap(String input) {
        if (input.equals("U")) {
            this.upMap.add(" X ");
            this.downMap.add("   ");
            return;
        }
        this.upMap.add("   ");
        this.downMap.add(" X ");
    }

    public void move() {
        this.index += 1;
    }


    public void retry() {
        this.index = 0;
        this.upMap.clear();
        this.downMap.clear();
        this.count++;
    }
}
