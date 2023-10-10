//640510658
package lab05_1_640510658;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;
class student{
    private String sub;
    private char grade;
    private int credit,point,point2,gpa,totalcr;
    public static int creadity=0,sumpoint;
    public static float grady =0; 
   
    
    public void setdata(int i){
        Scanner input = new Scanner(System.in);
        System.out.println("Subject #"+(i));
        System.out.print("Input Grade: ");
        grade = input.nextLine().charAt(0);
        System.out.print("Input Credit: ");
        credit = input.nextInt();
    }
    
    public void calgrade01(){
        if (grade =='A') {
            point2 = 4;
            point = 4*credit;}
        else if(grade == 'B'){
            point2 = 3;
            point = 3*credit;
        }
        else if(grade == 'C') {
            point2 = 2;
            point = 2*credit;
        }
        else if(grade == 'D') {
            point2 = 1;
            point = credit;
        }
        else {
            point2 = 0;
            point = 0;
        }
        creadity = creadity + credit;
        grady = grady + point;
    }
    public void print02(int i){
        System.out.println("Subject" +(i+1)+'\t'+ "    " + grade+'\t'+'\t' + point2+'\t'+'\t' + credit+'\t'+'\t'+ point);
    }
    public static void print03(){
        sumpoint = (int) grady;
        System.out.println("Total" + '\t' +'\t'+'\t' +'\t'+'\t' +'\t'+ creadity+ '\t'+'\t'+sumpoint);
        System.out.println("GPA = " +grady/creadity);
    }
}
public class Lab05_1_640510658 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input N : ");
        int N;
        N = input.nextInt();
        student[] sc = new student[50];
        for (int i=0;i<N;i++){
            sc[i] = new student();
            sc[i].setdata(i+1);
            sc[i].calgrade01();
        }
        System.out.print('\t' + "           Grade" + '\t'  + "GradePoint" + '\t' + "Credit" );
        System.out.print('\t' +"  Tatalpoint");
        System.out.print('\n');
        for (int i=0;i<N;i++){
            sc[i].print02(i);
        }
        student.print03();
        
    }
}
