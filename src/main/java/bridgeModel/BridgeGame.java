package bridgeModel;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    private final List<String> answerBridge;

    private int count = 1;

    private int index = 0;

    public BridgeGame(int size) {
        this.answerBridge = bridgeMaker.makeBridge(size);
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

    public void move() {
        this.index += 1;
    }

    public void retry() {
        this.index = 0;
        this.count++;
    }
}
