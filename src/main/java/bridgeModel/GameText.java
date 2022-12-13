package bridgeModel;

public enum GameText {

    UP("U"),
    DOWN("D"),
    SUCCESS(" O "),
    FAIL(" X "),
    EMPTY("   ");

    private final String text;

    private GameText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
