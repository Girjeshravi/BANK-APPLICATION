package banking;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Which bank You want to open an account");
        System.out.println("print 1 to create in lotak and 2 creat in sbi");
        Scanner sc=new Scanner(System.in);
        int option =sc.nextInt();

        System.out.println("ENTER PASS AND INTITIAL DEPOSIT");
        String password=sc.next();
        Integer initialBalance= sc.nextInt();
        double account =Math.abs(Math.random()*Math.pow(10,9));
        String stringversion=String.valueOf(account);


        RBIBankInterface bankaccount;
        if(option==1){
            bankaccount=new LotakBank(stringversion,password,initialBalance);
        }
        else{
            bankaccount=new SBIBank(stringversion,password,initialBalance);
        }
        String result=bankaccount.withdrawMoney(70000,"rosh123");
        System.out.println(result);

        result=bankaccount.withdrawMoney(70000,"rosh123");
        System.out.println(result);
        result=bankaccount.depositMoney(70000);
        System.out.println(result);
        System.out.println("rosh123");
        System.out.println(bankaccount.calculateTotalInterest(3));
    }
}