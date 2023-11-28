import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MazeLevelThree extends JPanel implements KeyListener {

private static final int CELL_SIZE = 50; // size of each cell in the grid
private static final int GRID_WIDTH = 10; // width of the grid in cells
private static final int GRID_HEIGHT = 10; // height of the grid in cells
public static final Color BLUESCLUES = new Color(51,204,255);

private int playerX; // x coordinate of the player in cells
private int playerY; // y coordinate of the player in cells
private static final boolean[][] obstacles = new boolean[GRID_WIDTH][GRID_HEIGHT];
private static final boolean[][] displayWin = new boolean[GRID_WIDTH][GRID_HEIGHT];
private boolean gameWon = false;

public MazeLevelThree() {

setFocusable(true);
addKeyListener(this);



obstacles[5][0] = true;
obstacles[6][0] = true;
obstacles[7][0] = true;
obstacles[8][0] = true;
obstacles[9][0] = true;

obstacles[1][1] = true;
obstacles[2][1] = true;
obstacles[3][1] = true;
obstacles[7][1] = true;

obstacles[5][2] = true;
obstacles[7][2] = true;
obstacles[9][2] = true;



obstacles[0][3] = true;
obstacles[2][3] = true;
obstacles[3][3] = true;
obstacles[5][3] = true;

obstacles[0][4] = true;
obstacles[3][4] = true;
obstacles[4][4] = true;
obstacles[5][4] = true;
obstacles[6][4] = true;
obstacles[7][4] = true;
obstacles[8][4] = true;

obstacles[0][5] = true;
obstacles[1][5] = true;
obstacles[3][5] = true;
obstacles[7][5] = true;


obstacles[3][6] = true;
obstacles[5][6] = true;
obstacles[7][6] = true;
obstacles[9][6] = true;

obstacles[1][7] = true;
obstacles[2][7] = true;
obstacles[3][7] = true;
obstacles[5][7] = true;
obstacles[6][7] = true;
obstacles[9][7] = true;

obstacles[1][8] = true;
obstacles[2][8] = true;
obstacles[3][8] = true;
obstacles[5][8] = true;
obstacles[6][8] = true;
obstacles[8][8] = true;
obstacles[9][8] = true;

obstacles[5][9] = true;
obstacles[6][9] = true;

displayWin[9][9] = true;
}

public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the maze
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                if (obstacles[i][j]) {
                    g.setColor(Color.YELLOW);
                } else {
                    if(displayWin[9][9] && (i==9 && j==9))
                        g.setColor(Color.RED);
                    else
                        g.setColor(Color.BLACK);
                }
                g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }

// draw the player
g.setColor(Color.WHITE);
g.fillRect(playerX * CELL_SIZE, playerY * CELL_SIZE , CELL_SIZE, CELL_SIZE);

}

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int newX = playerX;
        int newY = playerY;

        if (key == KeyEvent.VK_UP) {
            newY--;
        } else if (key == KeyEvent.VK_DOWN) {
            newY++;
        } else if (key == KeyEvent.VK_LEFT) {
            newX--;
        } else if (key == KeyEvent.VK_RIGHT) {
            newX++;
        }

        // check if new position is within the bounds of the grid and if it is an obstacle
        if (newX >= 0 && newX < GRID_WIDTH && newY >= 0 && newY < GRID_HEIGHT && !obstacles[newX][newY]) {
            playerX = newX;
            playerY = newY;
        }

        if(displayWin[9][9] == (newX == 9 && newY == 9) && !gameWon){
            gameWon = true;
            JOptionPane.showMessageDialog(null, "Congratulations, you completed the A-Mazing Game!");
           
        }
       

        repaint();
    }

public void keyReleased(KeyEvent e) {
}

public void keyTyped(KeyEvent e) {
}

public static void main3(String[] args) {
JFrame frame = new JFrame();
frame.add(new MazeLevelThree());
frame.setSize(516, 537);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

}

}