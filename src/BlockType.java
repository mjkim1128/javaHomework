import java.awt.Color;
public enum BlockType {
    RED_BLOCK(1, Color.RED),
    TEAL_BLOCK(2, new Color(54, 117, 136)),
    DOGERS_BLUE_BLOCK(3, new Color(0, 90, 156)),
    YELLOW_BLOCK(4, Color.YELLOW),
    ORANGE_BLOCK(5, Color.ORANGE),
    PURPLE_BLOCK(6, new Color(153, 51, 255)),
    GREEN_BLOCK(7, Color.GREEN);

    private int value;
    private Color color;

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    BlockType(int value, Color color) {
        this.value = value;
        this.color = color;
    }
}

