import java.awt.geom.Rectangle2D;

public class TealBlock extends Block{

    
    public TealBlock(double x, double y){
        super(x,y);
        init(x,y);
        type = BlockType.TEAL_BLOCK;
    }

    @Override
    public void init(double x, double y) { // RedBlock init 내부구현
        rectangles[0] = new Rectangle2D.Double(x, y, BLOCK_WIDTH, BLOCK_WIDTH);
        rectangles[1] = new Rectangle2D.Double(x, y + BLOCK_WIDTH, BLOCK_WIDTH, BLOCK_WIDTH);
        rectangles[2] = new Rectangle2D.Double(x, y + 2*(BLOCK_WIDTH), BLOCK_WIDTH, BLOCK_WIDTH);
        rectangles[3] = new Rectangle2D.Double(x, y + 3*(BLOCK_WIDTH), BLOCK_WIDTH, BLOCK_WIDTH);
    }
}