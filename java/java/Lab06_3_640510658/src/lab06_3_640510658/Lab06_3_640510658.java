    //640510658
package lab06_3_640510658;
import java.util.Scanner;
class voter{
    private int daram,daraf;
    private String name;
    int getm;
    int getf;
    String getn;
    public voter(){}
    public voter(int i){
        System.out.println("Input vote#"+i);
    }
    public void setdata(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input name:");
        name = input.next();
        System.out.print("Input number of actor and actress:");
        daram = input.nextInt();
        daraf = input.nextInt();
        System.out.println();
    }
    public int getm(){
        return daram;
    }
    public int getf(){
        return daraf;
    }
    public String getn(){
        return name;
    }
}
class star{
    private String name;
    private int number,amount;
    public star(int x,String y,int z){
        number = x;
        name = y;
        amount = z;
    }
    public void sumvote(){
        amount = amount + 1;
    }
    public int getamount(){
        return amount;
    }
    public String getname(){
        return name;
    }


}
public class Lab06_3_640510658 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input N: ");
        int n = input.nextInt();
        voter[] people = new voter[n];
        star mstar[] = {new star(1,"Nadech",0),new star(2,"Wier",0),new star(3,"Mario",0)};
        star fstar[] = {new star(1,"Aum",0),new star(2,"Yaya",0),new star(3,"Bella",0)};
        for (int i=0;i<n;i++){
            people[i] = new voter(i+1);
            people[i].setdata();
            mstar[(people[i].getm())-1].sumvote();
            fstar[(people[i].getf())-1].sumvote();
        }

        int []winner = new int[2];
        checkandprint(mstar,fstar,people,n,winner);
        printgoodluckpeople(people,winner,n);
        
    }
    public static void checkandprint(star mstar[],star fstar[],voter people[],int n,int winner[]){
        int maxm=0,maxf=0,minm,minf;
        for (int i=0;i<mstar.length;i++){
            if (mstar[i].getamount()>maxm){
                maxm = mstar[i].getamount();
                winner[0] = i;
            } 
            if (fstar[i].getamount()>maxf){
                maxf = fstar[i].getamount();
                winner[1] = i;
            }
        }
        System.out.println("Top star award(Actor) goes to "+mstar[winner[0]].getname());
        System.out.println("Top star award(Actor) goes to "+fstar[winner[1]].getname());
    }
    public static void printgoodluckpeople(voter people[],int winner[],int n){
        System.out.print("Good luck voter-> ");
        //System.out.println(winner[0]);
        //System.out.println(winner[1]);
        for (int i=0;i<n;i++){
            if (((people[i].getm())== (winner[0]+1))&&((people[i].getf())== (winner[1]+1))){
                System.out.print(people[i].getn()+" ");
            }
        }
    }
}

  
