
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victoralonso
 */
public class Snake {
    
    private Direction direction;
    private List<Node> body;
    private int remainingNodesToCreate = 0;
    
    
    public Snake(int row, int col, int size) { // Initial position of the head of the snake and number of inital nodes
        // Finish this method
        body = new ArrayList<Node>();
        for(int i=0; i < size; i++) {
            body.add(new Node((row), (col) - i));
        }
    }
    
    public boolean canMove(int row, int col) {
        // Finish this method
        return true;
    }
    
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        // Finish this method. Call Util.drawSquare()
        boolean colorHead = false;
            for (Node node: body) {
                if(!colorHead) {
                    Util.drawSquare(g, squareWidth, squareHeight, node.getCol(),node.getRow() , Color.green);
                    colorHead = true;
                } else {
                     Util.drawSquare(g, squareWidth, squareHeight, node.getCol(),node.getRow() , Color.red);
                }
            }
    }
    
    public void move() {
        // Finish this method
        int row = body.get(0).getRow();
        int col = body.get(0).getCol();
        switch(direction) {
            case UP:
                //here if(canMove(row-1))
                moveUp();
                break;

            case DOWN:
                moveDown();
                break;
           case LEFT:
                moveLeft();
                break;

           case RIGHT:
                moveRight();
                break;

        }
    }
    
    public void moveUp() {
        body.add(0, new Node(body.get(0).getRow() - 1, body.get(0).getCol()));
        body.remove(body.size() - 1);
    }
    
    public void moveDown() {
        body.add(0, new Node(body.get(0).getRow() + 1, body.get(0).getCol()));
        body.remove(body.size() - 1);
    }
    
    public void moveRight() {
        body.add(0, new Node(body.get(0).getRow(), body.get(0).getCol() + 1));
        body.remove(body.size() - 1);
    }
    
    public void moveLeft() {
        body.add(0, new Node(body.get(0).getRow(), body.get(0).getCol() - 1));
        body.remove(body.size() - 1);
    }
    
    
    
}
