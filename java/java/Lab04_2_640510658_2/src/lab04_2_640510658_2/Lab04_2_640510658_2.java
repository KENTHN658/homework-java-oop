/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab04_2_640510658_2;
import java.util.Scanner;
class matrix{
    //640510658
    private int n;
    private int[][] arrmatrix = new int [50][50];
    private int h,l;
    private String c;
    Scanner input = new Scanner(System.in);
    public void getdata(){
        //Scanner input = new Scanner(System.in);
        System.out.print("Input size N : ");
        n = input.nextInt();
    }
    public void setmatrix(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("Input number[%d][%d]: ",i,j);
                arrmatrix[i][j] = input.nextInt();
            }
            System.out.print("\n");
        }
    }
    public void cale(){
        h = 0;
        l = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i==j){
                    h = h + arrmatrix[i][j];
                }
                if ( i+j == (n-1)){
                    l = l + arrmatrix[i][j];
                }
            }
        }
        //System.out.println(h);
        //System.out.println(l);
    }
    public void decide(){
        if (h == l){
            c = "Equal";
        }
        else if(h != l){
            c = "Not Equal";
        }
    }
    public void print(){
        //int i,j;
        //for(i=0;i<n;i++){
          //for(j=0;j<n;j++)
            //   System.out.printf("%4d",arrmatrix[i][j]);
            //System.out.println();
        //}
        System.out.print(c);
    }
}
public class Lab04_2_640510658_2 {
    public static void main(String[] args) {
        matrix obj = new matrix();
        obj.getdata();
        obj.setmatrix();
        obj.cale();
        obj.decide();
        obj.print();
        
    }
    
}
