//640510658
package lab11_1_640510658;

import java.util.ArrayList;
import java.util.Scanner;


public class Lab11_1_640510658 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Character []cdata = new Character[5];
        Integer []idata = new Integer[5];
        Float []fdata = new Float[5];
        System.out.print("Enter 3 integer number");
        System.out.println();
        for(int i=0;i<3;i++){
           int x = input.nextInt();
           idata[i] = x;
        }
        System.out.print("Enter 3 Character");
        System.out.println();
        for(int i=0;i<3;i++){
           char x = input.next().charAt(0);
           cdata[i] = x;
        }
        System.out.print("Enter 3 float");
        System.out.println();
        for(int i=0;i<3;i++){
           float x = input.nextFloat();
           fdata[i] = x;
        }
        sort(idata);
        sort(cdata);
        sort(fdata);
    }
    public static <type extends Comparable> void sort(type data[]){
        type temp;
        int i,j;
        for(i=0;i<3;i++){
            for(j=i+1;j<3;j++){
                if(data[i].compareTo(data[j])>0){
                    temp = data[i];
                    data[i] = data[j];
                    data[j]= temp;}
            }
        }
        System.out.println();
        System.out.print(data[1]);
    }
    
}
