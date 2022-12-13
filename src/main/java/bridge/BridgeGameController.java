package bridge;

import View.InputView;
import View.OutputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();

    private final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;

    public void progressGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int size = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(size);
        this.handleMoving(size);
    }

    public void compareAnswer(int size, String input) {
        if (bridgeGame.isSameValue(input)) {
            handleSame(size, input);
            return;
        }
        handleDiff(size, input);
    }

    public void handleSame(int size, String input) {
        bridgeGame.drawSuccessMap(input);
        if (bridgeGame.getIndex() == size-1) {
            outputView.printResult(bridgeGame.getUpMap(), bridgeGame.getDownMap(), bridgeGame.getCount());
            return;
        }
        outputView.printMap(bridgeGame.getUpMap(), bridgeGame.getDownMap());
        bridgeGame.move();
        this.handleMoving(size);
    }

    public void handleDiff(int size, String input) {
        bridgeGame.drawFailMap(input);
        outputView.printMap(bridgeGame.getUpMap(), bridgeGame.getDownMap());
        String finishCommand = inputView.readGameCommand();
        if (finishCommand.equals("R")) {
            bridgeGame.retry();
            this.handleMoving(size);
            return;
        }
        outputView.printFailResult(bridgeGame.getUpMap(), bridgeGame.getDownMap(), bridgeGame.getCount());
    }

    public void handleMoving(int size) {
        String input = inputView.readMoving();
        this.compareAnswer(size, input);
    }


}
