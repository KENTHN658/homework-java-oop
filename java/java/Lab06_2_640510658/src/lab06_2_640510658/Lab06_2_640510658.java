//640510658
package lab06_2_640510658;
import java.util.Scanner;
class human{
    private int h,w,sd,absw;
    private char s;
    private String n;
    public void setdata(int i){
        Scanner input=new Scanner(System.in);
        System.out.println("Input data for person#"+(i+1));
        System.out.print("Input name : ");
        n = input.next();
        System.out.print("Input height: ");
        h = input.nextInt();
        System.out.print("Input weight: ");
        w = input.nextInt();
        System.out.print("Input sex: ");
        s = input.next().charAt(0);
    }
    public void wsd(){
        if (s=='F'){
            sd = h-110;
        }
        if (s=='M'){
            sd = h-100;
        }
    }
    public void absw(){
        absw = Math.abs(sd-w);
    }
    public int getabsw(){
        return absw;
    }
    public String getname(){
        return n;
    }
}
public class Lab06_2_640510658 {
    public static void main(String[] args) {
        human []obj = new human[2];
        for(int i=0;i<2;i++){
            obj[i] = new human();
            obj[i].setdata(i);
            obj[i].wsd();
            obj[i].absw();
            System.out.print('\n');
        }
        printstand(obj);
    }
    public static void printstand(human obj[]){
        if (obj[0].getabsw()==obj[1].getabsw()){
            System.out.print("The weight of both of then are close to the standard weight equally.");
        }
        if (obj[0].getabsw()<obj[1].getabsw()){
            System.out.print("Weight of "+obj[0].getname()+"is closer to standard weight than "+obj[1].getname());
        }
        if (obj[0].getabsw()>obj[1].getabsw()){
            System.out.print("Weight of "+obj[1].getname()+"is closer to standard weight than "+obj[0].getname());
        }
    }
    
}
