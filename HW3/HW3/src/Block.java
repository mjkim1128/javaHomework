public class Block {
    private BlockType type;
    private Square [] squares;

    public Block(BlockType type, Square[] squares) {
        this.type = type;
        this.squares = squares;
    }

    public BlockType getType() {
        return this.type;
    }

    public void setType(BlockType type) {
        this.type = type;
    }

    public Square[] getSquares() {
        return this.squares;
    }

    public void setSquares(Square[] squares) {
        this.squares = squares;
    }

    @Override
    public String toString() {
        return "{" +
            " type='" + getType() + "'" +
            ", squares='" + getSquares() + "'" +
            "}";
    }
    public void translate(int dx, int dy) {
        for (Square square : squares) {
            square.translate(dx, dy);
        }
    }
}
