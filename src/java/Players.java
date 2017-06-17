/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author e13183
 */
public class Players {
    
    private String name;
    private int x;
    private int y;
    private int score;

    public Players(String name, int x, int y, int score) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return score;
    }

    public void setX(int x) {
        this.x = x;
         
    }

    public void setY(int y) {
        this.y = y;
        
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
    

    @Override
    public String toString() {
        //return "Players{" + "name=" + name + ", x=" + x + ", y=" + y + ", score=" + score + '}';
        return "["+"\""+name+"\""+","+x+","+y+","+score+"]";
    }
    
    public static void main(String[] args){
    Players p=new Players("P1",2,40,4);
    
    System.out.println(p);
    
    }
    
}
