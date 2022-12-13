package bridge;

import bridgeModel.GameText;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public List<String> makeBridge(int size) {
        List<String> answerBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            if (number == 0) answerBridge.add(GameText.DOWN.getText());
            if (number == 1) answerBridge.add(GameText.UP.getText());
        }
        return answerBridge;
    }
}
