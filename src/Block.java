import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Random;

public abstract class Block implements IMovealbe, IColliding{
    protected double BLOCK_WIDTH = 50;
    protected BlockType type;
    protected Rectangle2D[] rectangles = new Rectangle2D[4];
    protected Block(double x, double y) { 
        init(x, y); 
    }
    //protected double intersectionArea;
    public abstract void init(double x, double y);

    public void translate(double dx, double dy){
        double randDx = new Random().nextDouble(50) -25;
        double randDy = new Random().nextDouble(50) -25;
        for (int i=0; i<4; i++) {
        double newX = rectangles[i].getX() + randDx;
        double newY = rectangles[i].getY() + randDy;
        rectangles[i].setFrame(newX, newY, BLOCK_WIDTH, BLOCK_WIDTH);
        }
    }
    
    public boolean collideWith(Block other){
        for (Rectangle2D rect1 : rectangles) {
            for (Rectangle2D rect2 : other.rectangles) {
                if (rect1.intersects(rect2)) {
                    return true; // 첫 번째 겹치는 부분을 찾았으므로 바로 종료
                }
            }
        }
        return false;
    }

    public static double getIntersectionArea(Rectangle2D rect1, Rectangle2D rect2) {
        if (rect1.intersects(rect2)) {
            // 교차 영역 구하기
            Rectangle2D intersection = rect1.createIntersection(rect2);
            // 교차 영역의 넓이 계산
            return intersection.getWidth() * intersection.getHeight();
        } else {
            // 교차하지 않는 경우 넓이는 0
            return 0.0;
        }
    }
    
    
    public boolean isBelow(double d, double e, double f, double g) {
        Rectangle2D bound = new Rectangle2D.Double(d, e, f, g);
        for (Rectangle2D rect : rectangles) {
            double intersectionArea = getIntersectionArea(bound,rect);
            if (intersectionArea != 4*BLOCK_WIDTH*BLOCK_WIDTH ) { 
                return false; 
            }
        }
        return true;
    }
        
    

    public BlockType getType(){
        return this.type;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
       // BlockFactory blockInstance = new BlockFactory();
        sb.append("Block Info: [");
        if (rectangles != null) {
            for (int i = 0; i < rectangles.length; i++) {
                sb.append(rectangles[i].toString());
                if (i < rectangles.length - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("] / ");
        sb.append(type);
        return sb.toString();
    }
}
