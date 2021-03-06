
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

/*


/**
 *
 * @author victoralonso
 */
public class Board extends javax.swing.JPanel {
    
    private final int INITIAL_DELTA_TIME = 400;
    private static int numRows = 25;
    private static int numCols = 25;
    private Snake snake;
    private Food food;
    private Food specialFood;
    private Timer snakeTimer;
    private Timer specialFoodTimer;
    private int deltaTime;
    private ScoreBoard scoreBoard;

    /**
     * Creates new form Board
     */
    
    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(snake.getDirection() != Direction.RIGHT){
                        snake.setDirection(Direction.LEFT);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(snake.getDirection() != Direction.LEFT){
                        snake.setDirection(Direction.RIGHT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(snake.getDirection() != Direction.DOWN){
                        snake.setDirection(Direction.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(snake.getDirection() != Direction.UP){
                        snake.setDirection(Direction.DOWN);
                    }
                    break;
                default:
                    break;
            }
            repaint();
        }
    }
    
    public Board() {
        initComponents();
        myInit();
    }
    
    private void myInit() {
        // Finish this method
        setFocusable(true);
        snake = new Snake(10, 10, 1);
        food = new Food(snake, false);
        addKeyListener(new MyKeyAdapter());
        deltaTime = INITIAL_DELTA_TIME; 
    }
    
    public void setScoreBoard(ScoreBoard scoreBoard){
        this.scoreBoard = scoreBoard;
    }
    
    public Board(int numRows, int numCols) {
        // Finish this method
        initComponents();
        myInit();
        this.numRows = numRows;
        this.numCols = numCols;
    
    }
    
    public boolean colideFood() {
        // Finish this method
        return false;
    }
    
    public void gameOver() {
        // Finish this method
    }
    
    
    
    @Override 
    protected void paintComponent(Graphics g)  {
        // Finish this method
        // Paint the Snake and the food here
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        snake.paintSnake(g2d, squareWidth(), squareHeight());
        food.paint(g, squareWidth(), squareHeight());

    }
    
    private int squareWidth(){
        return getWidth() / AspectsConfig.NUM_COLS;
    }

    private int squareHeight(){
        return getHeight() / AspectsConfig.NUM_ROWS;
    }

    private void drawSquare(Graphics g, int row, int col, int squareWidth, int squareHeight, Color color){
        int x = col * squareWidth;
        int y = row * squareHeight;
        g.drawLine(x, y + squareHeight - 1, x, y);
        g.drawLine(x, y, x + squareWidth - 1, y);
        g.drawLine(x + 1, y + squareHeight - 1,
        x + squareWidth - 1, y + squareHeight - 1);
        g.drawLine(x + squareWidth - 1,
        y + squareHeight - 1,
        x + squareWidth - 1, y + 1);
    }

    private void drawBoard(Graphics2D g2d){
        for(int row = 0; row < AspectsConfig.NUM_ROWS; row++){
            for(int col = 0; col < AspectsConfig.NUM_COLS; col++){
                drawSquare(g2d, row, col, squareWidth(), squareHeight(), Color.DARK_GRAY);
            }
        }
    }
    
    
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playBoard = new javax.swing.JPanel();

        javax.swing.GroupLayout playBoardLayout = new javax.swing.GroupLayout(playBoard);
        playBoard.setLayout(playBoardLayout);
        playBoardLayout.setHorizontalGroup(
            playBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );
        playBoardLayout.setVerticalGroup(
            playBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel playBoard;
    // End of variables declaration//GEN-END:variables
}
