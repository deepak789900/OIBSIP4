package com.examsys;

import javax.swing.*;
import java.util.Scanner;

public class OXE {
    private  String username;
    private String password;
    private boolean islogin;
    private  int timeremain;
    private int quationcount;
    private int[] userans;
    private int[] correctans;
    public OXE(String username,String password){
        this.username=username;
        this.password=password;
        System.out.println("Now you are login :");
        this.islogin=false;
        this.timeremain=10;
        this.quationcount=10;
        this.userans=new int[quationcount];
        this.correctans=new int[quationcount];
        for(int i=0;i<quationcount;i++){
            correctans[i]=(int)Math.round(Math.random());
        }

    }
    public void login(){
        System.out.println("Fill the information :");
        Scanner sc=new Scanner(System.in);
        System.out.println("Username :");
        String inputuser=sc.nextLine();
        System.out.println("Password :");
        String ippassword=sc.nextLine();
        if(inputuser.equals(username)&&ippassword.equals(password)){
            islogin=true;
            System.out.println("You are now login");
        }else {
            System.out.println("login Failed, Please try again");
        }

    }
    public void logout(){
        islogin=false;
        System.out.println("Logout Successfully");

    }
    public void startexam(){
        if(!islogin){
            islogin=false;
            System.out.println("Please login");
            return;
        }
        Scanner sc =new Scanner(System.in);
        System.out.println("You have "+timeremain+" minutes to complete exam.");
        for(int i=0;i<quationcount;i++){
            System.out.println("Quation "+(i+1)+ ":");
            System.out.println("1. Option a");
            System.out.println("2. Option b");
            System.out.println("Your are Answer(a or b)");
            char ans=sc.next().charAt(0);
            userans[i]=ans;
        }
        System.out.println("Would you like to submit ? \n1:YES \n:NO");
        int n=sc.nextInt();
        if(n==1){
            submitexam();
        }else {
            try {
                Thread.sleep(timeremain*10*1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                submitexam();
            }
        }
    }
    public void submitexam(){
        if(!islogin){
            System.out.println("Please Login First");
            return;
        }
        int score=0;
        for(int i=0;i<quationcount;i++){
            if(userans[i] == correctans[i]){
                score++;
            }
        }
        System.out.println("Your Score is "+ score +"out of"+quationcount+" ");
        logout();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username");
        String uname=sc.next();
        System.out.println("Enter your password");
        String pd=sc.next();
        OXE examsystem= new OXE(uname,pd);
        examsystem.login();
        examsystem.startexam();

    }
}
