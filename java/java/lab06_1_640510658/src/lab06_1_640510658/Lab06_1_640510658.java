//640510658
package lab06_1_640510658;
import java.util.Scanner;
class drawing{
    public void drawtriangle(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (i+j<n){
                    System.out.print("*");
                }
            }
            System.out.print('\n');
        }
            
    }
    public void drawtriangle(int n, char x){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (i+j<n){
                    System.out.print(x);
                }
            }
            System.out.print('\n');
        }
    }
    public void drawtriangle(int n, char x, char type){
        int k=0;
        if(type =='L'){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (i+j == k){
                        System.out.print(" ");
                    }
                    else if (i+j<n){
                        System.out.print(x);
                    }
                }
                System.out.print('\n');
               
            }
        }
        if(type =='R'){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    System.out.print(" ");
                }
                for(int j=i;j<=n;j++){
                    System.out.print(x);
                }
            System.out.println();
            } 
        }
        
    }
}
public class Lab06_1_640510658 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input N: ");
        int n = input.nextInt();
        System.out.print("Input X: ");
        char x = input.next().charAt(0);
        System.out.print("Input Type: ");
        char type = input.next().charAt(0);
        drawing obj = new drawing();
        obj.drawtriangle(n);
        obj.drawtriangle(n,x);
        obj.drawtriangle(n,x,type);
    }
    
}
