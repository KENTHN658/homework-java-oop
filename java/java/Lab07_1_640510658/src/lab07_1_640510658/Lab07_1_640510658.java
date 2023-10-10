//640510658
package lab07_1_640510658;
import java.util.Scanner;
import java.util.ArrayList;
class human{
    private String name,lastname;
    private char type;
    private int age,study,salary;
    public void setdatahuman(int i){
        Scanner input = new Scanner(System.in);
        System.out.print("(Input person #" + i + "(Teacher or Student) : ");
        type = input.next().charAt(0);
        System.out.print("Input frist name :");
        name = input.next();
        System.out.print("Input last name: ");
        lastname = input.next();
        System.out.print("Input age: ");
        age = input.nextInt();
        if ( type =='t'){
            System.out.print("Input Salary: ");
            salary = input.nextInt();
        }
        if (type == 's'){
            System.out.print("Input Study year");
            study = input.nextInt();
        }
    }
    public char gettype(){
        return type;
    }
    public int getage(){
        return age;
    }
    public String getname(){
        return name;
    }
    public String getlastname(){
        return lastname;
    }
    public int getsy(){
        return study;
    }
    public int getsa(){
        return salary;
    }
}

public class Lab07_1_640510658 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input N:");
        int n = input.nextInt();
        human []hu = new human[n];
        for(int i=0;i<n;i++){
            hu[i]= new human();
            hu[i].setdatahuman(i+1);
        }
        printallstudent(hu,n);
        printallteacher(hu,n);
        float x = calandprintavgage(hu,n);
        counteacher(x,hu,n);
        }
        public static void printallstudent(human hu[],int n){
            int ii=1;
            System.out.println("Student");
            System.out.println("    " + "Firtname"+"        "+"Lastname"+"  "+"Age"+"   "+"Study year");
            for (int i=0;i<n;i++){
                if (hu[i].gettype()=='s'){
                    System.out.println( (ii)+ "    "+hu[i].getname()+"             "+hu[i].getlastname()+"      "+hu[i].getage()+"      "+hu[i].getsy());
                    ii =ii+1;
                }
            }
        }
        public static void printallteacher(human hu[],int n){
            int ii=1;
            System.out.println("Teacher");
            System.out.println("    " + "Firtname"+"        "+"Lastname"+"  "+"Age"+"   "+"Salary");
            for (int i=0;i<n;i++){
                if (hu[i].gettype()=='t'){
                    System.out.println( (ii)+ "    "+hu[i].getname()+"             "+hu[i].getlastname()+"      "+hu[i].getage()+"  "+hu[i].getsa());
                    ii = ii+1;
                }
            }
        }
        public static float calandprintavgage(human hu[],int n){
            int ts =0,k=0;
            int tt =0,o=0;
            for (int i=0;i<n;i++){
                if (hu[i].gettype()=='t'){
                    tt = tt + hu[i].getage();
                    o = o + 1;
                }
                if (hu[i].gettype()=='s'){
                    ts = ts + hu[i].getage();
                    k = k + 1;
                }
            }
            float bs = (float) tt/ (float) o;
            float bc = (float) ts/ (float) k;
            System.out.printf("Average of Student age = %.2f" ,bc);
            System.out.println();
            System.out.printf("Average of teacger age = %.2f" ,bs);
            System.out.println();
            return bs;
        }
        public static void  counteacher(float avg,human hu[],int n){
            int y = 0;
            for (int i=0;i<n;i++){
                if ((hu[i].gettype()=='t') && ((float)hu[i].getage()<avg)){
                    y = y +1;
                }
            }
            System.out.println("Number of teacher who have age below average = " + y);
            
        } 
        
        
        
    }
    

