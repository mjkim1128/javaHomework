import java.util.Random;

public class Square {
    private int width;
    private Point upperLeft;
    private Point lowerRight;

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getUpperLeft() {
        return this.upperLeft;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    public Point getLowerRight() {
        return this.lowerRight;
    }

    public void setLowerRight(Point lowerRight) {
        this.lowerRight = lowerRight;
    }

    @Override
    public String toString() {
        return "{" +
            " width='" + getWidth() + "'" +
            ", upperLeft='" + getUpperLeft() + "'" +
            ", lowerRight='" + getLowerRight() + "'" +
            "}";
    }

    public void translate(int dx, int dy) {
        this.upperLeft.translate(dx, dy);
        this.lowerRight.translate(dx, dy);
    }
    
    
    
    

    public Square(Point upperLeft, int width) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.lowerRight = new Point(upperLeft.getX() + width, upperLeft.getY() + width);
    }
}
