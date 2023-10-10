//640510658
package lab05_4_640510658;
import java.util.Scanner;
import java.util.ArrayList;
class myquene{
    private ArrayList q = new ArrayList();
    private ArrayList floor = new ArrayList();
    private ArrayList eq = new ArrayList();
    private ArrayList fq = new ArrayList();
    private int d = 0,labanoon = 0;
    public void setdata(String x,String z){
        floor.add(z);
        q.add(x);
        //System.out.print(floor);
        //System.out.print(q);
    }
    public ArrayList getfloor(){
        return floor;
    }
    public ArrayList getq(){
        return q;
    }
    public void setVe(String e){
        eq.add(e);
        labanoon = labanoon + 1;
        //System.out.print(eq);
    }
    public int getla(){
        return labanoon;
    }
    public ArrayList gete(){
        return eq;
    }
    public int D(){
        d = d +1;
        return d;
    }
    public void calquene(){
        //[1, 1, 1, 2, 2, 3, 3]f
        //[11, 12, 13, 21, 22, 31, 32]q
        //[22, 11, 21, 32, 31, 12]eq
        //String x = (String) eq.get(0);
        //int labanoon = eq.size();
        while(eq.size()>0){
            String x =(String) eq.get(0);
            int y = q.indexOf(x);
            String z = (String) floor.get(y);
            fq.add(q.get(y));
            floor.remove(y);
            q.remove(y);
            eq.remove(0);
            while (floor.contains(z)){
                int aa = floor.indexOf(z);
                String cc = (String) q.get(aa);
                if (eq.contains(cc)){
                    fq.add(cc);
                    int jj = eq.indexOf(cc);
                    eq.remove(jj);
                }
                floor.remove(aa);
                q.remove(aa);
            }
                
        }        
        //System.out.println(fq);
    }
    public void print(){
        if (labanoon==d){
            for(int i=0;i<d;i++){
                System.out.println(fq.get(i));
            }
        }
        if (labanoon<d){
            for(int i=0;i<d;i++){
                if(i<labanoon){
                    System.out.println(fq.get(i));
                }
                else if(i>=labanoon){
                    System.out.println("empty");
                }
            }
        }
        if (labanoon>d){
            for(int i=0;i<d;i++){
                System.out.println(fq.get(i));
            }
        }
        System.out.println("0");
    }
}
public class Lab05_4_640510658 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        myquene obj = new myquene();
        //System.out.print("Class = ");
        int clases = input.nextInt();
        //System.out.print("Nstu = ");
        int nstu = input.nextInt();
        for(int i=0;i<clases;i++){
            for(int j=-1;j<nstu;j++){
                String x =input.next();
                String z =input.next();
                obj.setdata(z,x);
                obj.getClass();
                obj.getfloor();
                nstu = nstu-1;
            }
        }
        System.out.println("bbbb");
        boolean v = true;
        do{
            String E = input.next();
            String s1 = E;
            String s2 = "X";
            String s3 = "E";
            String s4 = "D";
            if (s1.equals(s3)){
                String stu = input.next();
                obj.setVe(stu);
                obj.gete();
            }
            if  (s1.equals(s4)){
                obj.D();
            }
            if  (s1.equals(s2)){
                v = false;
            }
            obj.getla();
        }while(v!=false);
        //System.out.print(obj.D());
        //[1, 1, 1, 2, 2, 3, 3]
        //[11, 12, 13, 21, 22, 31, 32]
        //[22, 11, 21, 32, 31, 12]
        obj.calquene();
        obj.print();
    }  
}
    

