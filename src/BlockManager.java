import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BlockManager extends JPanel implements ActionListener {
    private Timer timer = null;
    private final static int DELAY = 500; // 500 msec delay   
    private Block[] blocks = new Block[4];

    public BlockManager() {
        timer = new Timer(DELAY, this); // timer ActionListener event (500ms DELAY)
        this.setDoubleBuffered(true);
        blocks[0] = BlockFactory.getInstance(BlockType.RED_BLOCK, 50.0, 0.0);
        blocks[1] = BlockFactory.getInstance(BlockType.TEAL_BLOCK, 180.0, 10);
        blocks[2] = BlockFactory.getInstance(BlockType.DOGERS_BLUE_BLOCK, 70.0, 170.0);
        blocks[3] = BlockFactory.getInstance(RandomUtils.randomBlockType(), RandomUtils.randomDouble(200.0,400.0), RandomUtils.randomDouble(20.0,40.0));
    }

    // translate    
    public void translate(int index, double dx, double dy) {
        blocks[index].translate(dx, dy);
    }

    // below bottom line
    /*public void checkBelowBottomLine() {
        for (Block block : blocks) {
            if (block.isBelow(0.0, 600.0, 600.0, 600.00)) {
                System.out.println(block.getType() + " is below bottomLine");
                block = null;
            }
        }
    }*/

    // collide
    public void collide() {
        for (Block block : blocks) {
            for (Block otherBlock : blocks) {
                if (block != otherBlock && block.collideWith(otherBlock)) {
                    System.out.println(block.getType() + " collide with " + otherBlock.getType());
                    System.out.println();
                } 
            }
        }
    }

    // paint
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // JPanel paintComponent
        Graphics2D g2 = (Graphics2D) g;
        for (var block : blocks) { // RED_BLOCK, TEAL_BLOCK, DOGERS_BLUE_BLOCK, RANDOM_BLOCK    
            if (block != null) block.draw(g2);
        }
    }    

    // ActionListener actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i< blocks.length; i++) {           
            translate(i, RandomUtils.randomInt(-1, 2), RandomUtils.randomInt(1, 5));
        }
        //checkBelowBottomLine(); // check below Bottom Line
        collide(); // check collide
        repaint(); // repaint
    }

    // timer start
    public void start() {
		if (timer.isRunning()) 
			timer.restart();
		else 
		    timer.start();
	}

    // timer stop
	public void stop() {
        timer.stop();
	}
}