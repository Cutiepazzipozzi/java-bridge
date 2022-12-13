package bridge;

import bridgeModel.BridgeDraw;
import bridgeModel.BridgeGame;
import view.InputView;
import view.OutputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();

    private final OutputView outputView = new OutputView();

    private final BridgeDraw bridgeDraw = new BridgeDraw();

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
        bridgeDraw.drawSuccessMap(input);
        if (bridgeGame.getIndex() == size-1) {
            outputView.printResult(bridgeDraw.getUpMap(), bridgeDraw.getDownMap(), bridgeGame.getCount());
            return;
        }
        outputView.printMap(bridgeDraw.getUpMap(), bridgeDraw.getDownMap());
        bridgeGame.move();
        this.handleMoving(size);
    }

    public void handleDiff(int size, String input) {
        bridgeDraw.drawFailMap(input);
        outputView.printMap(bridgeDraw.getUpMap(), bridgeDraw.getDownMap());
        String finishCommand = inputView.readGameCommand();
        if (finishCommand.equals("R")) {
            handleRestart(size);
            return;
        }
        outputView.printFailResult(bridgeDraw.getUpMap(), bridgeDraw.getDownMap(), bridgeGame.getCount());
    }

    public void handleRestart(int size) {
        bridgeGame.retry();
        bridgeDraw.clear();
        this.handleMoving(size);
    }

    public void handleMoving(int size) {
        String input = inputView.readMoving();
        this.compareAnswer(size, input);
    }


}
