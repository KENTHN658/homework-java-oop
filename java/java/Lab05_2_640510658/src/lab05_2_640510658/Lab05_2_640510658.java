//640510658
package lab05_2_640510658;
import java.util.Scanner;
class box{
    private String s;
    private float widht,lenght,height,volume;
    public  box(String n ,float w,float l,float h){
        System.out.println("Hellow from 1st constuctor");
        s = n;
        widht = w;
        lenght = l;
        height = h;
    }
    public  box(){
        System.out.println("Hellow from 2nd constuctor");
    }
    public void setdata(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input Name of Box: ");
        s = input.next();
        System.out.print("Input Width: ");
        widht = input.nextFloat();
        System.out.print("Input Lenght:");
        lenght = input.nextFloat();
        System.out.print("Input Height: ");
        height = input.nextFloat();
    }
    public void caldata(){
        volume = widht*lenght*height;
    }
    public void printbox(){
        System.out.println("The Volume of Box:" + s + " = " + volume);
    }
}
public class Lab05_2_640510658 {
    public static void main(String[] args) {
        box obj1 = new box("SizeA", 14, 20, 6);
        obj1.caldata();
        obj1.printbox();
        box obj2 = new box();
        obj2.setdata();
        obj2.caldata();
        obj2.printbox();
    }
    
}
