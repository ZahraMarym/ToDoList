/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.todolist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;
class MyList{
    String date, time, subject, description, location;   
    MyList(){
    this.date = null;
    this.time = null;
    this.subject = null;
    this.description = null;
    this.location = null;
    }
    ArrayList<String> list = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public void insert(){
        list.add(date);
        list.add(time);
        list.add(subject);
        list.add(description);
        list.add(location);
      
    }
    public void update(){
        System.out.print("Enter date of the task which you want to update : ");
        String upd = input.next();
        if(list.contains(upd)){
            System.out.println("Which slot do you want to update?");
            System.out.print("1.Date\n2.Time\n3.Subject\n4.Description\n5.Location\nEnter your choice : ");
            int choice = input.nextInt();
            switch(choice){
                case 1 : {
                    System.out.print("Enter updated date : ");
                    String d = input.next();
                    int a = list.indexOf(upd);
                    list.set(a, d);
                    System.out.println("Your date have been updated successfully.");
                }
                break;
                case 2 : {
                    System.out.print("Enter updated time : ");
                    String t = input.next();
                    int a = list.indexOf(upd)+1;
                    list.set(a, t);
                    System.out.println("Your time have been updated successfully.");
                }
                break;
                case 3 : {
                    System.out.print("Enter updated subject : ");
                    String s = input.next();
                    int a = list.indexOf(upd)+2;
                    list.set(a, s);
                    System.out.println("Your subject have been updated successfully.");
                }
                break;
                case 4 : {
                    System.out.print("Enter updated description : ");
                    String d = input.next();
                    int a = list.indexOf(upd)+3;
                    list.set(a, d);
                    System.out.println("Your description have been updated successfully.");
                }
                break;
                case 5 : {
                    System.out.print("Enter updated location : ");
                    String l = input.next();
                    int a = list.indexOf(upd)+4;
                    list.set(a, l);
                    System.out.println("Your location have been updated successfully.");
                }
                break;
            }
        } else {
            System.out.println("You have not added any task at " + date + " yet.");    
                }  
    }
    public void search(){
        System.out.print("Enter date at which you want to check whether any task is present or not : ");
        String d = input.next();
        if(list.contains(d)){
            System.out.println("yes, Task is present at " + d + ".");   
        }  else {
            System.out.println("No task is present at " + d + " yet.");    
               }  
    }
    public void noOfTask(){
         System.out.println("You have added " + list.size()/5 + " tasks yet.");
    }
    public void specificDisplay(){
        System.out.print("Enter date at which you want to see your task : ");
        String d = input.next();
        if(list.contains(d)){
            int i = list.indexOf(d);
            System.out.println("Date : " + list.get(i) + "\nTime : " + list.get(i+1) + "\nSubject : " + list.get(i+2));
            System.out.println("Description : " + list.get(i+3) + "\nLocation : " + list.get(i+4));
        } else {
            System.out.println("No task is present at " + d + " yet.");
        }
    }
    public void allDisplay() {
       if(list.isEmpty()){

       } else {
           for(String elements : list){               
               System.out.println(elements);
           }
       }
    }  
    public void storeInDisk() throws FileNotFoundException{
        PrintStream console = System.out;
        PrintStream fileOut = new PrintStream("./ToDoList.txt");
          System.setOut(fileOut);
          System.setOut(console);
          System.out.println("Saved");
    }
    public void fileReader() throws IOException{
    try (
        FileReader readfile = new FileReader("C:\\Users\\Zahra Maryam\\Desktop\\ToDoList.txt")) {
                    int z;
                    while((z=readfile.read())!=-1)
                        System.out.print((char)z);
                }
    System.out.println("Saved tasks have been read from harddisk.");
    }
}
    

