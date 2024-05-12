import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Color;

public abstract class Block implements IMovealbe, IColliding{
    protected double BLOCK_WIDTH = 50;
    protected BlockType type;
    protected Rectangle2D[] rectangles = new Rectangle2D[4];
    protected Block(double x, double y) { 
        init(x, y); 
    }

    public abstract void init(double x, double y);

    public void translate(int dx, int dy){
        for (int i=0; i<4; i++) {
        double newX = rectangles[i].getX() + dx;
        double newY = rectangles[i].getY() + dy;
        rectangles[i].setFrame(newX, newY, BLOCK_WIDTH, BLOCK_WIDTH);
        }
    }

    public void collideWith(Block other){
        
    }

    public void draw(Graphics2D g2) { // draw based on init rectangles
    for (var rect : rectangles) {
    // fill with blockType color
    g2.setPaint(type.getColor());
    g2.fill(rect);
    // draw BLACK border line
    g2.setPaint(Color.BLACK);
    g2.draw(rect);
        }
    } 
}
