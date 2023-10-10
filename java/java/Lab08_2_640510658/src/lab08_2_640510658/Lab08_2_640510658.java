//640510658
package lab08_2_640510658;
import java.util.Scanner;
class land{
    Scanner input = new Scanner(System.in);
    private int land;
    public void set_land(){
        System.out.print("Enter number of land size: ");
        land = input.nextInt();
    }
    public int get_land(){
        return land;
    }
}
class land_of_house extends land{
    private int price;
    public land_of_house(int i){
        System.out.println("Enter data for house #"+(i+1));
    }
    public void set_price(){
        System.out.print("Enter house price: ");
        price = input.nextInt();
    }
    public int get_price(){
        return price;
    }
}
class land_of_sale extends land{
    private int e_price,status;
    private float total_price;
    private String title;
    public land_of_sale(int i){
        System.out.println("Enter data for land #"+(i+1));
    }
    public void set_data(){
        System.out.print("Enter title drrd: ");
        title =  input.next();
        System.out.print("Enter Evaluate price: ");
        e_price = input.nextInt();
        status=0;
    }
    public int status(){
        return status;
    }

    public int sale_status(){
        status = status+1;
        return status;
    }
    public String get_title(){
        return title;
    }
    
    
    public void sale_price(int hprice){
        total_price = (float) (e_price + (e_price*0.1) + (hprice*0.05));
    }
    public float get_total(){
        return total_price;
    }
    public float get_eprice(){
        return e_price;
    }
    
}
public class Lab08_2_640510658 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of house: ");
        int n_h = input.nextInt();
        System.out.print("Enter number of land: ");
        int n_l = input.nextInt();
        
        land_of_house []obj1 = new land_of_house[n_h];
        for (int i=0; i<n_h; i++){
            obj1[i] = new land_of_house(i);
            obj1[i].set_land();
            obj1[i].set_price();
            System.out.println();
        }
        land_of_sale []obj2 = new land_of_sale[n_l];
        for (int i=0;i<n_l;i++){
            obj2[i] = new land_of_sale(i);
            obj2[i].set_land();
            obj2[i].set_data();
            System.out.println();
        }
        
        for (int i=0;i<n_h;i++){
            for (int j=0;j<n_l;j++){
                if (obj1[i].get_land()<obj2[j].get_land()){
                    if (obj2[j].sale_status() == 1){
                        obj2[j].sale_price(obj1[i].get_price());
                        break;
                    }
                }
            }
        }
        float kk=0;
        float uu=0;
        System.out.println("Report for lands which can be sold");
        System.out.println("Title deed  Sale price");
        for(int i=0;i<n_l;i++){
            if (obj2[i].status() == 1){
                System.out.printf("%s"+"\t"+"%.2f",obj2[i].get_title(),obj2[i].get_total());
                kk = kk + obj2[i].get_total();
                uu = uu + obj2[i].get_eprice();
                System.out.println();
            }
        }
        System.out.println();
        System.out.printf("Total profit = "+"%.2f",(kk-uu));
        
    }
    
}
