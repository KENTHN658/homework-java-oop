
package lab04_3_640510658;
//640510658
import java.util.ArrayList;
import java.util.Scanner;
class text{
    private ArrayList textb = new ArrayList();
    private ArrayList texta = new ArrayList();
    private char[] letter;
    private String word;
    Scanner input = new Scanner(System.in);
    public void setdata(){
        System.out.print("Input Text : ");
        word = input.next();
        word = word.toUpperCase();
    }
    public void tranfer_string_to_char(){
        letter = word.toCharArray();
        for (char c:letter){
            //System.out.println(c);
            char character = c;
            int ascii = (int) character;
            textb.add(ascii);
        }
        //System.out.println(textb);
    }
    public void plus_ascii(){
        for(int i=0;i<word.length();i++){
            int a = (int) textb.get(i);
            a = a +3;
            texta.add(a);
        }
        //System.out.println(texta);
    }
    public void print_ascii(){
        int num,k;
        k = word.length();
        k = k%3;
        for (int i=0;i<texta.size();i++ ){
            num = (int) texta.get(i);
            char c = (char) num;
            //System.out.print(c);
            if ((i+1) % 3 != 0 ){
                System.out.print(c);
            }
            if ((i+1) % 3 == 0 ){
                System.out.print(c+" ");
            }
            
        }
        if (k%3==1) System.out.print("##");
        if (k%3==2) System.out.print("#");
    }
    
}

public class Lab04_3_640510658 {

    public static void main(String[] args) {
        text obj = new text();
        obj.setdata();
        obj.tranfer_string_to_char();
        obj.plus_ascii();
        obj.print_ascii();
    }
    
}
