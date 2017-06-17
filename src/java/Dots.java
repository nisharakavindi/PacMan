
/**
 *
 * @author e13183
 */
public class Dots {
    private String colour;
    private int x;
    private  int y;


    public Dots(String colour, int x, int y) {
        this.colour = colour;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        //return "Players{" + "name=" + name + ", x=" + x + ", y=" + y + ", score=" + score + '}';
        return "["+"\""+colour+"\""+","+x+","+y+"]";
    }
    
    public static void main(String[] args){
   Dots p=new Dots("B",2,40);
    
    System.out.println(p);
    
    }
}
