//640510658.
package lab11_2_640510658;
//640510658
import java.util.Scanner;

class menu {
    private int choice,data,pop;
    public void setchoice(){
        System.out.println("*********");
        System.out.println("1.enqueue");
        System.out.println("2.deqeue");
        System.out.println("3.show");
        System.out.println("4.exit");
        System.out.println("*********");
        System.out.print("Please Select choice : ");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
    }
    public int getchoice(){
        return choice;
    }

}
class stack <type> {
    private int top=-1,max;
    private Object[] stacky;
    public stack(){}
    public void stack(int x){
        stacky = new Object[x];
        max = x;
    }
    public void push(type x){
        top = top + 1;
        stacky[top] = x;
    }
    public void pop(){
        System.out.println(stacky[0]);
        for(int i=0;i<top;i++){
            stacky[i]=stacky[i+1]; 
        }
        top = top - 1;
        
    }
    public void show(){
        //System.out.print('\n');
        for (int i=0;i<(top+1);i++){
            System.out.print(stacky[i] + " ");
        }
    }
    public boolean isemty(){
        if (top == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean isfull(){
        if (top == max-1){
            return false;
        }
        else{
            return true;
        }
    }
    public int gettop(){
        return top;
    }
   
}
public class Lab11_2_640510658 {

    public static <type> void main(String[] args) {
        Scanner input = new Scanner(System.in);
        menu obj = new menu();
        stack obj2 = new stack();
        System.out.print("Input N:");
        int xx = input.nextInt();
        System.out.print("Seclext int or char: ");
        char c = input.next().charAt(0);
        obj2.stack(xx);
        
        
        
        type para;
        
        
        
        //obj2.gettop();
        do{
            obj.setchoice();
            if (obj.getchoice()==1){
                if (obj2.isfull()==false){
                    System.out.println("Queue is full");
                }
                else if(obj2.isfull()==true){
                    System.out.print("Enter data ");
                    
                    
                    para = (type)(Character) input.next().charAt(0);
                    
                    
                    obj2.push(para);
                    obj2.gettop();
                    System.out.print("OK");
                    System.out.println();
                   
                }
            }
            if (obj.getchoice()==2){
                if (obj2.isemty()==false){
                    System.out.println("Queue is emty");
                }
                else if (obj2.gettop()>-1 && obj2.gettop()<5 ){
                    obj2.pop();
                    obj2.gettop();
                }
            }
            if (obj.getchoice()==3){
                if (obj2.isemty()==false){
                    System.out.println("Nothing to show");
                }
                else if(obj2.isemty()!=false){
                    obj2.show();
                    System.out.print('\n');
                }
            }
            //System.out.print(obj.getchoice());
            
        }while(obj.getchoice()!=4);
        System.out.println("Bye bye");
    }
    
}
