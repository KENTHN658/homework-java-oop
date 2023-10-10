from tkinter import*
import csv
from time import*

window = Tk()
window.configure(bg='gold')
window.minsize(550,400)
window.title('KK PERTROL STATION')

list_oil = ['disel','bensin','gasohol']
list_priceoils = [27.29,37.76,30]

#Funtion_fristpage
def firstpage():
    window.minsize(550,400)
    L_one1.grid(row=0,column=0,columnspan=4, padx=225,pady=20)
    title_one1.grid(row=1,column=1,pady=10)
    title_one2.grid(row=2,column=0,pady=10)
    User_one1.grid(row=2, column=1, sticky=W)
    btOK_one_Exit.grid(row=3,column=0,pady=60)
    btOK_one_Next.grid(row=3,column=2,pady=60)
    bt_turnovers.grid(row=3,column=1,pady=60)

#Funtion_secondpage
def secondpage():
    window.minsize(550,400)
    L_one1.grid_forget()
    title_one1.grid_forget()
    title_one2.grid_forget()
    User_one1.grid_forget()
    btOK_one_Exit.grid_forget()
    btOK_one_Next.grid_forget()
    bt_turnovers.grid_forget()
    L_two1.grid(row=0,column=0,columnspan=6, padx=225,pady=20)
    oil1.grid(row=1,column=0)
    oil2.grid(row=1,column=3)
    oil3.grid(row=1,column=4)
    title_two1.grid(row=2,column=3,pady=60)
    User_two1.grid(row=3, column=3, sticky=W)
    L_two2.grid(row=3, column=4)
    please_two1.grid(row=5,column=3,padx=30)
    btOK_two_Back.grid(row=5,column=0,pady=60)
    btOK_two_Next.grid(row=5,column=4,pady=60)
    
#Funtion_Thridpage
def thridpage():
    window.minsize(550,400)
    try:
        if myint_oil.get() == list_oil[0]:
            getoils = float(User_two1.get())/list_priceoils[0]    
        elif myint_oil.get() == list_oil[1]:
            getoils = float(User_two1.get())/list_priceoils[1]  
        elif myint_oil.get() == list_oil[2]:
            getoils = float(User_two1.get())/list_priceoils[2]
        price3_1.config(text='{:.2f}    ลิตร '.format(getoils))
        oil_three2.config(text='{} '.format(myint_oil.get()))
        L_two1.grid_forget()
        oil1.grid_forget()
        oil2.grid_forget()
        oil3.grid_forget()
        title_two1.grid_forget()
        User_two1.grid_forget()
        L_two2.grid_forget()
        btOK_two_Back.grid_forget()
        btOK_two_Next.grid_forget()
        please_two1.grid_forget()
        L_three.grid(row=0,column=0,columnspan=6, padx=225,pady=20)
        name_three1.grid(row=1,column=0)
        name_three2.grid(row=1,column=1)
        oil_three1.grid(row=3,column=0)
        oil_three2.grid(row=3,column=1)
        price3.grid(row=4,column=0)
        price3_1.grid(row=4,column=1)
        close.grid(row=6,column=0)
        use_name=User_one1.get()
        name_three2.config(text=use_name)
        
        count_for = 0
        name_oil = ["","",""]
        name_remaining = ["","",""]
        with open('Oner_oil.csv','r',encoding='utf-8')as file:
          read_file=csv.reader(file)
          read_file_list=list(read_file)
        for i in read_file_list:
            name_oil[count_for]=str(i[0])
            name_remaining[count_for]=str(i[1])
            count_for+= 1
            
        if myint_oil.get() == list_oil[0]:
            name_remaining[0] ='{:.2f}'.format(float(name_remaining[0])- float(User_two1.get())/list_priceoils[0])    
        elif myint_oil.get() == list_oil[1]:
            name_remaining[1] = '{:.2f}'.format(float(name_remaining[1])- float(User_two1.get())/list_priceoils[1])    
        elif myint_oil.get() == list_oil[2]:
            name_remaining[2] = '{:.2f}'.format(float(name_remaining[2])- float(User_two1.get())/list_priceoils[2])   

        with open('Oner_oil.csv','w',encoding='utf-8')as file:
          writer=csv.writer(file,lineterminator='\n')
          writer.writerow([name_oil[0],name_remaining[0]])
          writer.writerow([name_oil[1],name_remaining[1]])
          writer.writerow([name_oil[2],name_remaining[2]])
        
        
    except Exception:
         please_two1.config(text="กรุณาเลือกชนิดน้ำมัน!!!")
        
    
    
#Comebackfirstpage
def backsecondpage():
    window.minsize(550,400)
    please_two1.grid_forget()
    L_two1.grid_forget()
    oil1.grid_forget()
    oil2.grid_forget()
    oil3.grid_forget()
    title_two1.grid_forget()
    User_two1.grid_forget()
    L_two2.grid_forget()
    btOK_two_Back.grid_forget()
    btOK_two_Next.grid_forget()
    oil2.grid_forget()
    window.minsize(550,400)
    L_one1.grid(row=0,column=0,columnspan=4, padx=225,pady=20)
    title_one1.grid(row=1,column=1,pady=10)
    title_one2.grid(row=2,column=0,pady=10)
    User_one1.grid(row=2, column=1, sticky=W)
    btOK_one_Exit.grid(row=3,column=0,pady=60)
    btOK_one_Next.grid(row=3,column=2,pady=60)



#turnovers_button
def turnovers():
    count_for = 0
    name_oil = ["","",""]
    name_remaining = ["","",""]
    with open('Oner_oil.csv','r',encoding='utf-8')as file:
      read_file=csv.reader(file)
      read_file_list=list(read_file)
    for i in read_file_list:
        name_oil[count_for]=str(i[0])
        name_remaining[count_for]=str(i[1])
        count_for+= 1

    window_turnovers = Toplevel(window)
    window_turnovers.minsize(550,400)
    
    L_one1= Label(window_turnovers,text ='KK \nPERTROL \nSTATION',
                  bg = "gold",fg="blue",font="Tahoma 20 bold")
    L_one1.grid(row=0,column=0,columnspan=6, padx=225,pady=20)
    
    title_turnovers1 = Label(window_turnovers,text='ชื่อน้ำมัน',
                             font="Tahoma 16 bold",bg = "gold",fg ="red")
    title_turnovers1.grid(row=1,column=0,pady=20)
    
    title_turnovers2 = Label(window_turnovers,text='น้ำมันคงเหลือ',
                             font="Tahoma 16 bold",bg = "gold",fg="blue")
    title_turnovers2.grid(row=1,column=2,pady=20)
    
    global title_turnovers2_1
    title_turnovers2_1 = Label(window_turnovers,text=name_remaining[0],
                             font="Tahoma 16 bold",bg = "gold",fg="blue")
    title_turnovers2_1.grid(row=2,column=2,pady=20)
    
    global title_turnovers2_2
    title_turnovers2_2 = Label(window_turnovers,text=name_remaining[1],
                             font="Tahoma 16 bold",bg = "gold",fg="blue")
    title_turnovers2_2.grid(row=3,column=2,pady=20)
    
    global title_turnovers2_3
    title_turnovers2_3 = Label(window_turnovers,text=name_remaining[2],
                             font="Tahoma 16 bold",bg = "gold",fg="blue")
    title_turnovers2_3.grid(row=4,column=2,pady=20)
    
    title_nameoil1 = Label(window_turnovers,text=name_oil[0],
                           font="Tahoma 16 bold",bg = "gold",fg ="red")
    title_nameoil1.grid(row=2,column=0,pady=20)
    
    title_nameoil1 = Label(window_turnovers,text=name_oil[1],
                           font="Tahoma 16 bold",bg = "gold",fg ="red")
    title_nameoil1.grid(row=3,column=0,pady=20)
    
    title_nameoil1 = Label(window_turnovers,text=name_oil[2],
                           font="Tahoma 16 bold",bg = "gold",fg ="red")
    title_nameoil1.grid(row=4,column=0,pady=20)
    
    global myint_oil_turnovers
    myint_oil_turnovers = IntVar()
    myint_oil_turnovers.set(0)
    
    oil1=Radiobutton(window_turnovers,text=name_oil[0],font='Tahoma 14 bold',
                     bg='gold',value=1,variable=myint_oil_turnovers)
    oil1.grid(row=5,column=0,pady=20)
    
    oil2=Radiobutton(window_turnovers,text=name_oil[1],font='Tahoma 14 bold',
                     bg='gold',value=2,variable=myint_oil_turnovers)
    oil2.grid(row=5,column=2,pady=20)

    oil3=Radiobutton(window_turnovers,text=name_oil[2],font='Tahoma 14 bold',
                     bg='gold',value=3,variable=myint_oil_turnovers)
    oil3.grid(row=5,column=4,pady=20)

    global User_turnovers1

    User_turnovers1 = Entry(window_turnovers,
                            width=28,font='Tahoma 12 bold')
    User_turnovers1 .focus()
    User_turnovers1 .grid(row=6,column=2,pady=20,padx=20)
    
    btOK_one_Exit = Button(window_turnovers, text='Exit',
            width=10,height = 1,command=window.destroy,
            bg='#ffaacc',font='Tahoma 12 bold')
    btOK_one_Exit.grid(row=7,column=0,pady=20)

    btOK_one_Add= Button(window_turnovers, text='Add',
            width=10,height = 1,command=Add_button_funtion,
            bg='#ffaacc',font='Tahoma 12 bold')
    btOK_one_Add.grid(row=7,column=4,pady=20)
    
    
#Add_button_funtion
def Add_button_funtion():
    count_for = 0
    name_oil = ["","",""]
    name_remaining = ["","",""]

    with open('Oner_oil.csv','r',encoding='utf-8')as file:
      read_file=csv.reader(file)
      read_file_list=list(read_file)
    for i in read_file_list:
        name_oil[count_for]=str(i[0])
        name_remaining[count_for]=str(i[1])
        count_for+= 1
    name_remaining[myint_oil_turnovers.get()-1] = User_turnovers1.get()

    with open('Oner_oil.csv','w',encoding='utf-8')as file:
      writer=csv.writer(file,lineterminator='\n')
      writer.writerow([name_oil[0],name_remaining[0]])
      writer.writerow([name_oil[1],name_remaining[1]])
      writer.writerow([name_oil[2],name_remaining[2]])
    title_turnovers2_1.config(text=name_remaining[0])
    title_turnovers2_2.config(text=name_remaining[1])
    title_turnovers2_3.config(text=name_remaining[2])
    

#Firstpage
myint = StringVar()
myinput = myint.get()
L_one1= Label(window,text ='KK \nPERTROL \nSTATION',bg = "gold",fg="blue",font="Tahoma 20 bold")
title_one1 = Label(window,text='**กรุณากรอกชื่อผู้ใช้**',font="Tahoma 14 bold",bg = "gold",fg ="red")
title_one2= Label(window, text='User.. ',font="Tahoma 16 bold",bg = "gold",fg="blue")
User_one1 = Entry(window,textvariable=myint.get(),width=28,font='Tahoma 12 bold')
User_one1.focus()
btOK_one_Exit = Button(window, text='Exit',
        width=10,height = 1,command=window.destroy,
        bg='#ffaacc',font='Tahoma 12 bold')

btOK_one_Next = Button(window, text='Next',
        width=10,height = 1,command=secondpage,
        bg='#ffaacc',font='Tahoma 12 bold')

bt_turnovers = Button(window, text='turnovers',
        width=10,height = 1,
        bg='#ffaacc',font='Tahoma 12 bold',command=turnovers)

#Secondpage
myint_oil = StringVar()
myint_oil.set('0')
L_two1= Label(window,text ='KK \nPERTROL \nSTATION',fg="blue",font="Tahoma 20 bold",bg = "gold")
oil1=Radiobutton(window,text=list_oil[0],font='Tahoma 14 bold',
                 bg='gold',value=list_oil[0],variable=myint_oil)

oil2=Radiobutton(window,text=list_oil[1],font='Tahoma 14 bold',
                 bg='gold',value=list_oil[1],variable=myint_oil)

oil3=Radiobutton(window,text=list_oil[2],font='Tahoma 14 bold',
                 bg='gold',value=list_oil[2],variable=myint_oil)

title_two1  = Label(window,text='**กรุณาใส่จำนวนเงิน**',
                    font="Tahoma 14 bold",bg = "gold",fg ="red")

L_two2= Label(window,text ='THB',fg="red",
              font="Tahoma 14 bold",bg = "gold")

please_two1= Label(window,text ='',fg="red",
              font="Tahoma 14 bold",bg = "gold")

User_two1 = Entry(window,
                  width=28,font='Tahoma 12 bold')
User_two1.focus()



btOK_two_Back = Button(window, text='Back',width=10,height = 1,
                    bg='#ffaacc',font='Tahoma 12 bold',command=backsecondpage)

btOK_two_Next = Button(window, text='Next',
        width=10,height = 1,command=thridpage,
        bg='#ffaacc',font='Tahoma 12 bold')



#Thridpage
L_three = Label(window,text ='KK \nPERTROL \nSTATION',fg="blue",
               font="Tahoma 20 bold",bg = "gold")
name_three1 = Label(window,text='Name',font='Tahoma 14 bold',bg='gold')
name_three2 = Label(window,text=' ',font='Tahoma 14 bold'
             ,bg='gold')
oil_three1 = Label(window,text='Type oil',font='Tahoma 14 bold'
             ,bg='gold',width=12,height=5)
oil_three2 = Label(window,text='',font='Tahoma 14 bold'
             ,bg='gold',height=13)
price3=Label(window,text='You will get oil',font='Tahoma 14 bold'
             ,bg='gold',fg='red',height=5)
price3_1=Label(window,text='',font='Tahoma 14 bold'
             ,bg='gold',fg='red',height=5)
close=Button(window,text='CLOSE',command=window.destroy,width=10,bg='firebrick'
                 ,fg='black',bd=10,font='Tahoma 9 bold')


firstpage()


mainloop()