//640510658
package lab05_3_640510658;
import java.util.Scanner;
class menu{
    private int choice,data,pop;
    public void setchoice(){
        System.out.println("*********");
        System.out.println("1.push");
        System.out.println("2.pop");
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
class stack{
    private int top=-1;
    private int[] stacky = new int[5];
    public stack(){int top = -1;}
    public void push(int x){
        top = top + 1;
        stacky[top] = x;
    }
    public void pop(){
        System.out.println("pop " + stacky[top]);
        stacky[top] = 0;
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
        if (top == 4){
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

public class Lab05_3_640510658 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        menu obj = new menu();
        stack obj2 = new stack();
        //obj2.gettop();
        do{
            obj.setchoice();
            if (obj.getchoice()==1){
                if (obj2.isfull()==false){
                    System.out.println("Stack is full");
                }
                else if(obj2.isfull()==true){
                    System.out.print("Enter data ");
                    int x = input.nextInt();
                    obj2.push(x);
                    obj2.gettop();
                   
                }
            }
            if (obj.getchoice()==2){
                if (obj2.isemty()==false){
                    System.out.println("Stack is emty");
                }
                else if (obj2.gettop()>-1 && obj2.gettop()<5 ){
                    obj2.pop();
                    obj2.gettop();
                }
            }
            if (obj.getchoice()==3){
                if (obj2.isemty()==false){
                    System.out.println("Stack is emty");
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
