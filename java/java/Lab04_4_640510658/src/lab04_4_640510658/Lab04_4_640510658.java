
package lab04_4_640510658;
import java.util.ArrayList;
import java.util.Scanner;
//640510658
class student {
    Scanner input = new Scanner(System.in);
    private ArrayList subject = new ArrayList();
    private ArrayList course = new ArrayList();
    private ArrayList namestu = new ArrayList();
    private ArrayList stucourse = new ArrayList();
    private String search;
    public void setdata(){
        System.out.print("Input number of students: ");
        int nstu = input.nextInt();
        for (int i=0; i< nstu;i++){
            System.out.print("\n");
            System.out.print("Student name: ");
            String stu = (String) input.next();
            namestu.add(stu);
            System.out.print("Number of sunject: ");
            int nsub = input.nextInt();
            subject.add(nsub);
            System.out.print("Course list: ");
            for (int j=0; j<nsub; j++){
                String cu = input.next();
                course.add(cu);
            }
        }
        System.out.print("\n");
        System.out.print("Input subject for searching: ");
        search = input.next();
        //System.out.print(namestu);
        //System.out.print(course);
        //System.out.print(subject);
    }
    public void seach(){
        for(int i=0; i<namestu.size();i++){
            int nsub = (int) subject.get(i);
            for(int j=0;j < nsub;j++){
                if ((course.get(0)).equals(search)){
                    stucourse.add(namestu.get(i));
                    course.remove(0);
                }
                else{
                    course.remove(0);
                }
            }
        }
        //System.out.print(stucourse);
    }
    public void print(){
        if (stucourse.size() != 0){
            int jj = stucourse.size();
            for (int i=0;i<jj;i++){
                System.out.println(stucourse.get(i));
            }
            System.out.println(jj + " student(s)");
        }
        else {
            System.out.println("0 student(s)");
        }
    }
}
public class Lab04_4_640510658 {
    public static void main(String[] args) {
        student obj = new student();
        obj.setdata();
        obj.seach();
        obj.print();
    }
    
}
