/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victoralonso
 */
public class Node {
    private int row;
    private int col;
    
    // Create the constructor and all the methods you need here
    
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getCol() {
        return col;
    }
    
    public int getRow() {
        return row;
    }
    
    public void setCol() {
        this.col = col;
    }
    
    public void setRow() {
        this.row = row;
    }
}
