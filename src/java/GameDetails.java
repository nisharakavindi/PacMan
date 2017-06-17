/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.*;
import java.util.*;
import java.util.logging.*;

final class GameDetails extends Thread {

    static final long INTERVAL = 2000;
    final Random rand = new Random();
    //final DateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);

    //private static String[] players={"[\"P1\", 8, 0, 0]","[\"P2\", 5, 44, 0]","[\"P3\", -6, 0, 44]","[\"P4\", 10, 44, 44]"};
    //String[] dots={"[\"B\", 5, 6]","[\"G\", 23, 12]" ,"[\"R\", 34, 7]","[\"B\", 25, 8]","[\"G\", 28, 1]","[\"R\", 42, 17]",
    //   "[\"B\", 15, 36]","[\"G\", 22, 22] ","[\"R\", 5, 37]","[\"B\", 25, 28]","[\"G\", 9, 39]","[\"R\", 10, 21] "};
    FoodPoints foods = new FoodPoints();
    Dots[] dots = foods.generateFoods();

    Players[] players = new Players[4];
    //Dots[] dots;
    Players p1 = new Players("P1", rand.nextInt(100), rand.nextInt(100), 0);
    Players p2 = new Players("P2", rand.nextInt(100), rand.nextInt(100), 0);
    Players p3 = new Players("P3", rand.nextInt(100), rand.nextInt(100), 0);
    Players p4 = new Players("P4", rand.nextInt(100), rand.nextInt(100), 0);

    public static String printArray(Object[] array) {
        return Arrays.toString(array);
    }

    public void changePosition(String message) {
        if (message.equals("ArrowUp")) {
            if (p1.getY() == 100) {
            } else {
                p1.setY(p1.getY() + 1);
            }

        } else if (message.equals("ArrowDown")) {

            if (p1.getY() == 0) {
            } else {
                p1.setY(p1.getY() - 1);
            }
        } else if (message.equals("ArrowLeft")) {
            if (p1.getX() == 0) {
            } else {
                p1.setX(p1.getX() - 1);
            }
        } else if (message.equals("ArrowRight")) {
            if (p1.getX() == 100) {
            } else {
                p1.setX(p1.getX() + 1);
            }
        } else {

        }

    }

    /**
     * Periodically updates stock info and notifies servlet threads.
     */
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                //price = 90 + rand.nextInt(20);
                //time = new Date();

                //.toString();
                players[0] = p1;
                players[1] = p2;
                players[2] = p3;
                players[3] = p4;

                Logger.getGlobal().log(Level.INFO, this.toString());
                notifyAll();
            }
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    @Override
    public String toString() {

        //return "{\"time\" :\""+df.format(time)+"\",\"price\":\""+price+"\"}";        
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "{\"DOTS\":" + printArray(dots) + ",\"PLAYERS\":" + printArray(players) + "}";
    }

}
