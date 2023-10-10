//640510658
package lab10_2_640510658;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape2Dim{
    protected int N;
    public void setN(int n){
        N= n;
    }
    public abstract void draw(); 
}
class Rhombus extends Shape2Dim{ 
    public Rhombus(){}
    public void draw(){ 
        if (N > 0) {
            int j,i;
            String fsq = "%" + N+"c\n";
            String fsq2;
            System.out.printf(fsq,'*');
            for (i=1; i<N;i++ ){ 
                fsq2 = "%" + (N-i)+"c%"+(2*i)+"c\n";
                System.out.printf(fsq2,'*','*');
            }
            for (i=N-2; i>=1;i-- ){ 
                fsq2 = "%" + (N-i)+"c%"+(2*i)+"c\n";
                System.out.printf(fsq2,'*','*');
            }
            System.out.printf(fsq,'*');
        }
    }
}
class square extends Shape2Dim {
    public square(){}
    public void draw(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==0 || i==(N-1) || j==(N-1) || j==0){
                    System.out.print('*'); 
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
class Triangle extends Shape2Dim {
    public Triangle(){}
    public void draw(){
         for (int i = N; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                System.out.print(" ");
            }
            for (int k = N; k >= i; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    } ///source https://dailyjavaconcept.com/pattern-program-set-6/ thanks you
}   


public class Lab10_2_640510658 {
    public static void main(String[] args) {
        int m,i1=0,n,i2=0,i3=0,i4=0;
        char type;
        Scanner input = new Scanner(System.in);
        System.out.print("input M:");
        m = input.nextInt();
        Shape2Dim []obj1 = new Rhombus[10];
        Shape2Dim []obj2 = new square[10];
        Shape2Dim []obj3 = new Triangle[10];
        ArrayList type1 = new ArrayList(); 
        ArrayList type2 = new ArrayList(); 
        ArrayList type3 = new ArrayList(); 
        do{
            System.out.print("Input Type (R S or T) and Size : ");
            type = input.next().charAt(0);
            n = input.nextInt();
            if (type == 'r'){
                obj1[i1] = new Rhombus();
                obj1[i1].setN(n);
                type1.add(type);
                i1++;
                i4++;
            }
            if (type == 's'){
                obj2[i2] = new square();
                obj2[i2].setN(n);
                type2.add(type);
                i2++;
                i4++;
            }
            if (type == 't'){
                obj3[i3] = new Triangle();
                obj3[i3].setN(n);
                type3.add(type);
                i3++;
                i4++;
            }
        }while(i4<m);
        System.out.println("Rhombus");
        for(int k=0; k<type1.size();k++){
            obj1[k].draw();
        }
        System.out.println("Square");
        for(int k=0; k<type2.size();k++){
            obj2[k].draw();
        }
        System.out.println("Triangle");
        for(int k=0; k<type3.size();k++){
            obj3[k].draw();
        }
    }
    
}
