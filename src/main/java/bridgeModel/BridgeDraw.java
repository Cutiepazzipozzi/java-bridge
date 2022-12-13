package bridgeModel;

import java.util.ArrayList;
import java.util.List;

public class BridgeDraw {

    private final List<String> upMap;

    private final List<String> downMap;

    public BridgeDraw() {
        upMap = new ArrayList<>();
        downMap = new ArrayList<>();
    }

    public List<String> getUpMap() {
        return this.upMap;
    }

    public List<String> getDownMap() {
        return this.downMap;
    }

    public void drawSuccessMap(String input) {
        if (input.equals(GameText.UP.getText())) {
            this.upMap.add(GameText.SUCCESS.getText());
            this.downMap.add(GameText.EMPTY.getText());
            return;
        }
        this.upMap.add(GameText.EMPTY.getText());
        this.downMap.add(GameText.SUCCESS.getText());
    }

    public void drawFailMap(String input) {
        if (input.equals(GameText.UP.getText())) {
            this.upMap.add(GameText.FAIL.getText());
            this.downMap.add(GameText.EMPTY.getText());
            return;
        }
        this.upMap.add(GameText.EMPTY.getText());
        this.downMap.add(GameText.FAIL.getText());
    }

    public void clear() {
        this.upMap.clear();
        this.downMap.clear();
    }
}
