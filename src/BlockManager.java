import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BlockManager extends JPanel implements ActionListener {
    private Timer timer = null;
    private final static int DELAY = 500; // 500 msec delay   
    Block[] blocks = new Block[4];
    public boolean collideCheck = false ;
    public BlockManager() {
        timer = new Timer(DELAY, this); // timer ActionListener event (500ms DELAY)
        this.setDoubleBuffered(true);
        blocks[0] = BlockFactory.getInstance(BlockType.RED_BLOCK, 50.0, 0.0);
        System.out.println(blocks[0].toString());
        
        blocks[1] = BlockFactory.getInstance(BlockType.TEAL_BLOCK, 180.0, 50);
        System.out.println(blocks[1].toString());

        blocks[2] = BlockFactory.getInstance(BlockType.DOGERS_BLUE_BLOCK, 100.0, 300.0);
        System.out.println(blocks[2].toString());
        
        blocks[3] = BlockFactory.getInstance(RandomUtils.randomBlockType(), RandomUtils.randomDouble(200.0,400.0), RandomUtils.randomDouble(20.0,40.0));
        System.out.println(blocks[3].toString());
    }

    public Block[] getBlocks() {
        return blocks;
    }

    // translate    
    public void translate(int index, double dx, double dy) {
        blocks[index].translate(dx, dy);
    }

    // below bottom line
    public boolean checkBelowBottomLine() {
        for (Block block : blocks) {
            if (block.isBelow(0.0, 600.0, 600.0, 600.00)) {
                System.out.println(block.getType() + " is below bottomLine");
                block = null;
                return false;
            }
        }
        return true;
    }

    // collide
    public boolean collide() {
        for (Block block : blocks) {
            for (Block otherBlock : blocks) {
                if (block != otherBlock && block.collideWith(otherBlock)) {
                    System.out.println(block.getType() + " collide with " + otherBlock.getType());
                    System.out.println();
                    return true;
                }
            }
        }
        return false;
    }

    // paint
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // JPanel paintComponent
        Graphics2D g2 = (Graphics2D) g;
        for (var block : blocks) { // RED_BLOCK, TEAL_BLOCK, DOGERS_BLUE_BLOCK, RANDOM_BLOCK    
           // System.out.println(block.toString());
            if (block != null) block.draw(g2);
        }
    }    

    // ActionListener actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i< blocks.length; i++) {           
            translate(i, RandomUtils.randomInt(-1, 2), RandomUtils.randomInt(1, 5));
        }
        if(checkBelowBottomLine()){
            stop();
        } // check below Bottom Line
        if(collide()){
            stop();
        }
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
        System.out.println("stop()");
        timer.stop();
	}
}