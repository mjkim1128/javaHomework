import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab4MainFrame extends JFrame implements KeyListener {
	private JPanel displayPanel = null;
	private BlockManager blockManager = null;
	private int selectedIndex = 0;

	public Lab4MainFrame(String title) {
		super(title);
		blockManager = new BlockManager();
		//blockManager.start(); // blockManager timer start
		displayPanel = new JPanel(new BorderLayout());
		displayPanel.add(blockManager, BorderLayout.CENTER);
		displayPanel.addKeyListener(this); // KeyListener
		displayPanel.setFocusable(true);
		displayPanel.requestFocusInWindow();
		this.getContentPane().add(displayPanel);

		this.setSize(600, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {  // handle right arrow key
            blockManager.translate(selectedIndex, 5.0, 0.0);  // move to the right
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {  // handle left arrow key
            blockManager.translate(selectedIndex, -5.0, 0.0);  // move to the left
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {  // handle up arrow key
            blockManager.translate(selectedIndex, 0.0, -5.0);  // move up (y decreases!)
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {  // handle down arrow key
            blockManager.translate(selectedIndex, 0.0, 5.0);  // move down (y increases!)
        } else if (e.getKeyCode() == KeyEvent.VK_1) {
			selectedIndex = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_2) {
			selectedIndex = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_3) {
			selectedIndex = 2;
		} else if (e.getKeyCode() == KeyEvent.VK_4) {
			selectedIndex = 3;
		}
		//blockManager.checkBelowBottomLine(); // blockManager checkBelowBottomLine
		blockManager.collide(); // blockManager check collide
		displayPanel.revalidate(); // repaint
		displayPanel.repaint(); // repaint
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

    public static void main(String[] args) {
        new Lab4MainFrame("Block");
    }
}
