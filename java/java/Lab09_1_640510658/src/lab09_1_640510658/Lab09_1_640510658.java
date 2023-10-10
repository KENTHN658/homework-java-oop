//640510658
package lab09_1_640510658;
import java.util.Scanner;
class orderitem{
    private String food_name;
    private int price,num_dish;
    public void setdata(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter food name: ");
        food_name = input.nextLine();
        System.out.print("Enter price: ");
        price = input.nextInt();
        System.out.print("Enter dish: ");
        num_dish = input.nextInt();
    }
    public void show_data(){
        System.out.printf("%-20s" +"%-20s"+"%-20s",food_name,price,num_dish);
    }
    public int get_num_dish(){
        return num_dish;
    }
    public int get_price(){
        return price;
    }
}
class order{
    private String orderid,tableno;
    private orderitem []item = new orderitem[10];
    private int number_of_item;
    private double total_price;
    public void setdata(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter order ID: ");
        orderid = input.next();
        System.out.print("Enter table NO: ");
        tableno = input.next();
        System.out.print("Enter number of Food item: ");
        number_of_item = input.nextInt();
    }
    public void addorder(){
        for(int i=0; i<number_of_item; i++){
            System.out.println("*******************************");
            item[i] = new orderitem();
            item[i].setdata();
        }
    }
    public void caltotal(){
        total_price = 0 ;
        for(int i=0;i<number_of_item;i++){
            total_price = total_price + (item[i].get_num_dish()*item[i].get_price());
        }
    }
    public void show_data(){
        System.out.println("Order ID- "+orderid+"       "+"Table No.- "+tableno);
        System.out.printf("%-20s" +"%-20s"+"%-20s","Food Name","Price/Dish(Baht)","QTY");
        System.out.println();
        for(int i=0;i<number_of_item;i++){
            item[i].show_data();
            System.out.println();
        }
        System.out.printf("Total Price = %.0f Bath",total_price);
    }
    
    
}
public class Lab09_1_640510658 {
    public static void main(String[] args) {
        order obj= new order();
        obj.setdata();
        obj.addorder();
        obj.caltotal();
        obj.show_data();
        
    }
    
}
