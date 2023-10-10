//64051658
package lab08_1_640510658;
import java.util.Scanner;
import java.util.ArrayList;
class product{
    Scanner input = new Scanner(System.in);
    private String isbn;
    private int price,orderno;
    public void setdata_of_product(){
        System.out.print("ISBN: ");
        isbn = input.next();
    }
    public void setdata_of_price(){
        System.out.print("Pricr: ");
        price = input.nextInt();
    }
    public String get_isbn(){
        return isbn;
    }
    public int get_price(){
        return price;
    }
    
}
class moviedvd extends product{
    private String director;
    public void setdata_dvd(){
        System.out.print("Director: ");
        director = input.next();
    }
    public String get_director(){
        return director;
    }
}
class ebook extends product{
    private String author;
    public void setdata_author(){
        System.out.print("Author: ");
        author = input.next();
    }
    public String get_author(){
        return author;
    }
}
class audio extends ebook{
    private String narrator;
    private int narrator_price;
    public void setdata_narrator(){
        System.out.print("Narrathor: ");
        narrator = input.next();
        System.out.print("Audio Price: ");
        narrator_price = input.nextInt();
    }
    public String get_narrator(){
        return narrator;
    }
    public int get_narrator_price(){
        return narrator_price;
    }
}
class order extends product{
    private int typ;
    private char ia;
    public void set_order(int i){
        System.out.println("Order #"+(i+1));
        System.out.print("type of product: ");
        typ =input.nextInt();
    }
    public void set_ai(){
        System.out.print("Included Audio: ");
        ia = input.next().charAt(0);
    }
    public int get_typ(){
        return typ;
    }
    public char get_ia(){
        return ia;
    }
}

public class Lab08_1_640510658 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of movie DVD: ");
        int n_dvd = input.nextInt();
        System.out.println();
        moviedvd []obj1 = new moviedvd[n_dvd];
        for(int i=0; i<n_dvd; i++){
            System.out.println();
            obj1[i] = new moviedvd();
            obj1[i].setdata_of_product();
            obj1[i].setdata_dvd();
            obj1[i].setdata_of_price();
            System.out.println();
        }
        System.out.println();
        System.out.print("Enter number of E-book: ");
        int n_e = input.nextInt();
        System.out.println();
        ebook []obj2 = new ebook[n_e];
        for (int i=0; i<n_e; i++){
            System.out.println();
            obj2[i] = new ebook();
            obj2[i].setdata_of_product();
            obj2[i].setdata_author();
            obj2[i].setdata_of_price();
            System.out.println();
        }
        System.out.println();
        System.out.print("Enter number of Audiobook: ");
        int n_a = input.nextInt();
        System.out.println();
        audio []obj3 = new audio[n_a];
        for (int i=0;i<n_a;i++){
            System.out.println();
            obj3[i] = new audio();
            obj3[i].setdata_of_product();
            obj3[i].setdata_author();
            obj3[i].setdata_of_price();
            obj3[i].setdata_narrator();
            System.out.println();
        }
        System.out.println();
        System.out.print("Enter number of orders for today: ");
        int n_o = input.nextInt();
        order []obj4 = new order[n_o];
        for(int i=0; i<n_o; i++){
            obj4[i] = new order();
            obj4[i].set_order(i);
            obj4[i].setdata_of_product();
            if(obj4[i].get_typ()==3){
                obj4[i].set_ai();
            }
        }
        calAndprint(obj1,obj2,obj3,obj4,n_dvd,n_e,n_a,n_o); 
        
    }
    public static void calAndprint(moviedvd []obj1,ebook []obj2,audio []obj3,order []obj4,int n_dvd,int n_e,int n_a,int n_o){
        ArrayList isbn = new ArrayList();
        ArrayList price = new ArrayList();
        ArrayList price_n = new ArrayList();
        ArrayList direc = new ArrayList();
        ArrayList narrow = new ArrayList();
        int []order = new int[n_dvd + n_e + n_a + n_o+1];
        int []total_price = new int[n_dvd + n_e + n_a + n_o+1];
        for(int i=0;i<n_dvd;i++){
            isbn.add(obj1[i].get_isbn());
            direc.add(obj1[i].get_director());
            narrow.add("-");
            price.add(obj1[i].get_price());
            price_n.add(0);
        }
        for(int i=0;i<n_e;i++){
            isbn.add(obj2[i].get_isbn());
            direc.add(obj2[i].get_author());
            narrow.add("-");
            price.add(obj2[i].get_price());

        
            price_n.add(0);
        }
        for(int i=0;i<n_a;i++){
            isbn.add(obj3[i].get_isbn());
            direc.add(obj3[i].get_author());
            narrow.add(obj3[i].get_narrator());
            price.add(obj3[i].get_price());
            price_n.add(obj3[i].get_narrator_price());
        }
        for(int i=0;i<n_o;i++){
            if (obj4[i].get_typ()==3 && (obj4[i].get_ia()== 'y')){
                int k = isbn.indexOf(obj4[i].get_isbn());
                total_price[k] = total_price[k] + (int) price.get(k) + (int)price_n.get(k) ;
                order[k] = order[k] + 1;
            }
            else if (obj4[i].get_typ()==1 ||obj4[i].get_typ()==2||obj4[i].get_typ()==3){
                int k = isbn.indexOf(obj4[i].get_isbn());
                total_price[k] = total_price[k] + (int) price.get(k);
                order[k] = order[k] + 1;
            }
        }
        System.out.print("Daily Order Report");
        System.out.println();
        System.out.print("ISBN       Director/Author   Narrator       Number of orders  Total Price");
        System.out.println();
        int ttpp=0;
        for (int i=0 ;i<n_dvd + n_e + n_a;i++){
            System.out.printf("%s",isbn.get(i));
            System.out.printf("%10s",direc.get(i));
            System.out.printf("%15s",narrow.get(i));
            System.out.printf("%20d",order[i]);
            System.out.printf("%25d",total_price[i]);
            ttpp = ttpp + total_price[i];
        }
        System.out.println("Total price = " + ttpp);
        
        
    }
    
}
