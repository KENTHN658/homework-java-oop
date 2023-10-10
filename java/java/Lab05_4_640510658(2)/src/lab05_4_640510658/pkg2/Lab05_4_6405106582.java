//640510658 แก้ไขอันเก่าผิดครับ
package lab05_4_640510658.pkg2;
import java.util.ArrayList;
import java.util.Scanner;
class myqueue{
    private ArrayList listq = new ArrayList();
    private ArrayList room = new ArrayList();
    private ArrayList people = new ArrayList();
    private ArrayList room2 = new ArrayList();
    public void setdata(int y,int z){
        room.add(y);
        people.add(z);
    }
    
    public void enqueue(int x){
        //room2.add(room.get(room.indexOf(x)));
        if ((room2.contains(room.get(people.indexOf(x))))&& (room2.get(0)==room.get(people.indexOf(x)))){ 
            
                listq.add(1,x);
                room2.add(1,room.get(people.indexOf(x)));
            
        }
        else{
            listq.add(x);
            room2.add(room.get(people.indexOf(x)));
        }
    }
    public int dequeue(int d){
        if (listq.size()>1){
            int data = (int) listq.get(0);
            room2.remove(0);
            listq.remove(0);
            int kon = people.indexOf(data);
            room.remove(kon);
            people.remove(kon);
            //System.out.print(data);
            return (data);
        }
        else{
            int data = (int) listq.get(0);
            return (data);
        }
    }
    public int size(){
        return (listq.size());
    }
    public void print(){
        for(int i=0;i<listq.size();i++){
            System.out.println(listq.get(i));
        }
    }
}
public class Lab05_4_6405106582 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int classe = input.nextInt();
        int student = input.nextInt();
        myqueue obj = new myqueue();
        for(int i=0; i< classe; i++){
            for(int j=-1; j<student ; j++){
                int y =input.nextInt();//room
                int z =input.nextInt();//human
                obj.setdata(y, z);
                student = student - 1;
            }
        }
        System.out.print('\n');
        ArrayList cc = new ArrayList();
        int d =0,loop=0;
        char jok;
        do{
            jok = input.next().charAt(0);
            if (jok == 'E' || jok == 'e'){
                int x = input.nextInt();
                loop = loop + 1;
                obj.enqueue(x);
                
            }
            if (jok =='D' || jok == 'd'){
                d = d + 1;
                cc.add(obj.dequeue(d));
            }
        }while(jok != 'X');
        //System.out.print(cc);
        if(loop >= d){
            for (int i=0;i<d;i++){
                System.out.println(cc.get(i));
            }
        }
        if(loop < d){
            for (int i=0;i<loop;i++){
                System.out.println(cc.get(i));
            }
            for (int i=0;i<(d-loop);i++){
                System.out.println("empthy");
            }
        }
        System.out.println(0);
    }
    
}
