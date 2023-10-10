//640510658
package lab10_1_640510658;

import java.util.ArrayList;
import java.util.Scanner;

abstract class student{
    protected String name;
    protected char grade;
    public int mid_score,fi_score;
    public Scanner input = new Scanner(System.in);
    public void set_data(){
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter midterm score: ");
        mid_score = input.nextInt();
        System.out.print("Enter final score: ");
        fi_score = input.nextInt();
    }
    public void print(){
      //  System.out.print(name + " gets grade " + grade);
    }
    public abstract char grade();
    
}

class graduate extends student{
    private int publication;
    public void set_reseach(){
        System.out.print("Enter number of publication: ");
        publication = input.nextInt();
    }

    @Override
    public char grade() {
        if (publication >= 2 &&  (mid_score+fi_score) >=60){
            return grade = 's';
        }
        else{
            return grade = 'u';
        }
    }
    public void print(){
        System.out.print(name +" get grade " + grade());
    }
    
    
}
class undergraduate extends student{
    private int project;
    public void set_project(){
        System.out.print("Enter number of project score: ");
        project = input.nextInt();
        
    }

    @Override
    public char grade() {
        if (project >= 50 &&  (mid_score+fi_score) >=50){
            return grade = 's';
        }
        else{
            return grade = 'u';
        }
    }
    public void print(){
        System.out.print(name +" get grade " + grade());
    }
    
}

public class Lab10_1_640510658 {
    public static void main(String[] args) {
        student []obj = new student[100];
        Scanner input = new Scanner (System.in);
        ArrayList word = new ArrayList();
        char choice,another;
        int i=0;
        do{
           System.out.print("Enter undergraduate student or graduate studenent(u/g): ");
           choice = input.next().charAt(0);
           word.add(choice);
           if (choice == 'g'){
               obj[i] = new graduate();
               obj[i].set_data();
               ((graduate)obj[i]).set_reseach();
               ((graduate)obj[i]).grade();
               i++;
           }
           else{
               obj[i] = new undergraduate();
               obj[i].set_data();
               ((undergraduate)obj[i]).set_project();
               ((undergraduate)obj[i]).grade();
               i++;
           }
           System.out.print("Enter anther(y/n)?: ");
           another = input.next().charAt(0);
           System.out.println();
        }while(another != 'n');

        report_grade(word,obj);
        
    }
    public static void report_grade(ArrayList word,student[]obj){
        int n_u=0,n_s=0;
        for(int k=0; k<word.size(); k++){
            if( (char)word.get(k) == 'g'){
               if (((graduate)obj[k]).grade()=='u'){
                   n_u = n_u+1;
               }
               else{
                   n_s = n_s+1;
               }
            }
            else{
                if (((undergraduate)obj[k]).grade()=='u'){
                   n_u = n_u+1;
               }
               else{
                   n_s = n_s+1;
               }
                 
            }
        }
        System.out.println("Grade Report");
        System.out.println("============");
        for(int k=0 ; k<word.size(); k++){
            if( (char)word.get(k) == 'g'){
                (obj[k]).print();
            }
            else{
                 (obj[k]).print();
            }
            System.out.println();
        }
        System.out.print("Total: Grade U = "+n_u+" Grade S = "+n_s);
    }
    
}
