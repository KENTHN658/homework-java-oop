//64051658
package lab07_2_640510658_2;
import java.util.Scanner;
class base{
    private String surname,name,id;
    public void setbase(int i){
        System.out.println("input person#"+(i+1));
        System.out.print("Input id: ");
        Scanner input = new Scanner(System.in);
        id = input.next();
        System.out.print("Input name: ");
        name = input.next();
        surname = input.next();
        name = name +" "+surname;
    }
    protected String getname(){
        return name;
    }
    protected String getid(){
        return id;
    }
}
class month extends base{
    private int period,salary,ot,ot_add_salary;
    public void setda(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input salary: ");
        salary = input.nextInt();
        System.out.print("Input overtime period: ");
        period = input.nextInt();
    }
    public void calot(){
        ot = period*200;
        ot_add_salary = ot + salary;
    }
    public String get_use_name(){
        return getname();
    }
    public String get_use_id(){
        return getid();
    }
    public int getsalary(){
        return salary;
    }
    public int getot(){
        return ot;
    }
    public int getot_add_salary(){
        return ot_add_salary;
    }
    
}
class partime extends base{
    private int sale,comrate,com;
    public void setta(){
        Scanner input = new Scanner(System.in);
        System.out.print("input Total sale: ");
        sale = input.nextInt();
        System.out.print("Input percent of commission rate: ");
        comrate = input.nextInt();
    }
    protected int getsale(){
        return sale;
    }
    protected int comrate(){
        return comrate;
    }
}

class week extends partime{
    private int netmoney,weekrate,wwork,wage,commy;
    public void setdata_of_week(){
        Scanner input = new Scanner (System.in);
        System.out.print("Input weekly rate: ");
        weekrate =  input.nextInt();
        System.out.print("Input working week: ");
        wwork = input.nextInt();
    }
    public void month_wagew(){
        wage = weekrate*wwork;
        netmoney = wage + (getsale()*comrate()/100);
        commy = (getsale()*comrate()/100);
    }
    public int getmonth_wagew(){
        return wage;
    }
    public int getwage_add_comw(){
        return netmoney;
    }
    public int getcommissionw(){
        return commy;  
    }
    public String get_use_namew(){
        return getname();
    }
    public String get_use_idw(){
        return getid();
    }
    
}
class daily extends partime{
    private int netmoney,wage,drate,day,commy;
    public void setdata_of_daily(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input daily rate: ");
        drate = input.nextInt();
        System.out.print("Input working day:");
        day = input.nextInt();
    }
    public void cal_money(){
        wage = drate*day;
        commy = (getsale()*comrate()/100);
        netmoney = wage + commy;
        
    }
    public int getmonth_waged(){
        return wage;
    }
    public int getcommissiond(){
        return commy;  
    }
    public int getwage_add_comd(){
        return netmoney;
    }
    public String get_use_named(){
        return getname();
    }
    public String get_use_idd(){
        return getid();
    }
}
public class Lab07_2_640510658_2 {
    public static void main(String[] args) {
        System.out.print("Input Number of monthly employees: ");
        Scanner input = new Scanner(System.in);
        int x1 = input.nextInt();
        System.out.print("\n");
        month []obj1 = new month[x1];
        for(int i=0; i<x1; i++){
            obj1[i]  = new month();
            obj1[i].setbase(i);
            obj1[i].setda();
            obj1[i].calot();
            System.out.print("\n");
            }
        System.out.print("...................."+"\n");
        System.out.print("Input Number of weekly employees: ");
        int x2 = input.nextInt();
        System.out.print("\n");
        week []obj2 = new week[x2];
        for(int i=0;i<x2;i++){
            obj2[i] = new week();
            obj2[i].setbase(i);
            obj2[i].setta();
            obj2[i].getsale();
            obj2[i].comrate();
            obj2[i].setdata_of_week();
            obj2[i].month_wagew();
            System.out.print("\n");
            }
        System.out.print("...................."+"\n");
        System.out.print("Input Number of daily employees: ");
        int x3 = input.nextInt();
        System.out.print("\n");
        daily []obj3 = new daily[x3];
        for(int i=0;i<x3;i++){
            obj3[i] = new daily();
            obj3[i].setbase(i);
            obj3[i].setta();
            obj3[i].getsale();
            obj3[i].comrate();
            obj3[i].setdata_of_daily();
            obj3[i].cal_money();
            System.out.print("\n");
            }
        int index = 0;
        System.out.println("                      ABC Company");
        monthemploy(obj1,x1);
        System.out.print("\n");
        weekemploy(obj2,x2);
        System.out.print("\n");
        dayemploy(obj3,x3);
        }
        public static void monthemploy(month []obj1,int x1){
            int all_salary =0;
            int all_ot = 0;
            int all = 0;
            for (int i=0;i<x1;i++){
                all_ot = all_ot + obj1[i].getot();
                all_salary = all_salary + obj1[i].getsalary();
            }
            all = all_salary + all_ot;
            System.out.println("Monthly Employees");
            System.out.println("ID"+"     "+"Name"+"     "+"Salary"+"     "+"Overtime wage"+"     "+"Total");
            for (int i=0;i<x1;i++){
                System.out.printf("%s",obj1[i].get_use_id());
                System.out.format("    %4s",obj1[i].get_use_name());
                System.out.printf("     %-3d",obj1[i].getsalary());
                System.out.printf("     %-6d",obj1[i].getot());
                System.out.printf("          %-5d",obj1[i].getot_add_salary());
                System.out.println();
            }
            System.out.println("Total"+"           "+all_salary+"      "+all_ot+"              "+all);
        }
        public static void weekemploy(week []obj1,int x1){
            int all_wage =0;
            int all_com = 0;
            int all = 0;
            for (int i=0;i<x1;i++){
                all_com = all_com + obj1[i].getcommissionw();
                all_wage = all_wage + obj1[i].getmonth_wagew();
            }
            all = all_wage + all_com;
            System.out.println("Weekly Employees");
            System.out.println("ID"+"     "+"Name"+"     "+"Commission"+"     "+"Monthly wage"+"     "+"Total");
            for (int i=0;i<x1;i++){
                System.out.printf("%s",obj1[i].get_use_idw());
                System.out.format("    %4s",obj1[i].get_use_namew());
                System.out.printf("     %-3d",obj1[i].getcommissionw());
                System.out.printf("     %-6d",obj1[i].getmonth_wagew());
                System.out.printf("          %-5d",obj1[i].getwage_add_comw());
                System.out.println();
            }
            System.out.println("Total"+"           "+all_com+"      "+all_wage+"              "+all);
        }
        public static void dayemploy(daily []obj1,int x1){
            int all_wage =0;
            int all_com = 0;
            int all = 0;
            for (int i=0;i<x1;i++){
                all_com = all_com + obj1[i].getcommissiond();
                all_wage = all_wage + obj1[i].getmonth_waged();
            }
            all = all_wage + all_com;
            System.out.println("Dayly Employees");
            System.out.println("ID"+"     "+"Name"+"     "+"Commission"+"     "+"Monthly wage"+"     "+"Total");
            for (int i=0;i<x1;i++){
                System.out.printf("%s",obj1[i].get_use_idd());
                System.out.format("    %4s",obj1[i].get_use_named());
                System.out.printf("     %-3d",obj1[i].getcommissiond());
                System.out.printf("     %-6d",obj1[i].getmonth_waged());
                System.out.printf("          %-5d",obj1[i].getwage_add_comd());
                System.out.println();
            }
            System.out.println("Total"+"           "+all_com+"      "+all_wage+"              "+all);
        }
    
    
}
