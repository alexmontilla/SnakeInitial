
import java.awt.Color;
import java.awt.Graphics;
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
public class Food {
    private Node position;
    private boolean isSpecial;
    
    public Food(Snake snake, boolean isSpecial) { 
        // We pass Snake to the constructor because if the randomnly generated food
        // falls on the Snake you have to create another position for the food
        position = generateFood(snake);
        this.isSpecial = isSpecial;
    }
    
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        // Finish this method. Call Util.drawSquare()
        if(isSpecial){
            Util.drawSquare(g, squareWidth, squareWidth, squareWidth, squareHeight, Color.BLUE);
        } else {
            Util.drawSquare(g, squareWidth, squareWidth, squareWidth, squareHeight, Color.GREEN);
        }

    }
    
    // Create all the methods you need here
    
    public boolean isSpecial(){
        return isSpecial;
    }

    public Node getPosition(){
        return position;
    }

    private Node generateFood(Snake snake) {
        List<Node> posSnake = snake.getNodes();
        Node food = null;
        boolean colision = true;
        while(colision){
            position = new Node((int)(Math.random()*(AspectsConfig.NUM_ROWS -1)), (int)(Math.random()*(AspectsConfig.NUM_COLS -1)));
            colision = false;
            for(Node x: posSnake){
                if(x == position){
                    colision = true;
                    break;
                }
            }
           
        }
        return food;
    }
}


    

