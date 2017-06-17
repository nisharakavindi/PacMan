
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Peshali
 */
public class FoodPoints {
   
    Dots[] dots=new Dots[12];
    int i;
    int count=0;
    final Random rand = new Random();
    
    public Dots[] generateFoods(){
        for(i=0;i<4;i++){
            
            Dots dot=new Dots("B",rand.nextInt(100),rand.nextInt(100));
            dots[i]=dot;
            count=i;
         }
        
            
        for(i=count;i<8;i++){
            
            Dots dot=new Dots("G",rand.nextInt(100),rand.nextInt(100));
            dots[i]=dot;
            
            count=i;
         }
         
        for(i=count;i<12;i++){
            
            Dots dot=new Dots("R",rand.nextInt(100),rand.nextInt(100));
            dots[i]=dot;
            count=i;
         }
         
       
        return dots;
    }
    
//    public static void main(String[] args){
//        FoodPoints food=new FoodPoints();
//        Dots[] d=food.generateFoods();
//        System.out.println(Arrays.toString(d));
//    }
//    
    
    
}
