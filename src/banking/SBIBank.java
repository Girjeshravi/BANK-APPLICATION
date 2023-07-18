package banking;

public class SBIBank implements RBIBankInterface {

    private String accNo;
    private String passCode;
    private double balance;
    private double rateOfInterest=6;
    public int minbalance=500;

    public SBIBank(String accountNo,String password,double balance){
        this.accNo=accNo;
        this.passCode=password;
        this.balance=balance;
    }
    @Override
    public String depositMoney(int money) {
        if(money>0){
            balance=balance+money;
            return "Money:m "+money+"has been added to your account.Total "+"balnce is "+balance;
        }
        else{
            return "Money entered is negative" ;
        }
    }

    @Override
    public String withdrawMoney(int money, String password) {
       if(this.passCode.equals(password)){
           if(this.balance-money>=minbalance){
               double bal=this.balance-money;
               return "money withdraw :"+money+ "and money left in your account is "+bal;
           }else{
               return "INSUFFICIENT BALANCE";
           }
       }
       else{
           return "Wrong PAssword";
       }
    }

    @Override
    public String checkBalance(String password) {
        if(this.passCode.equals(password)){
            return "balance in account is :"+balance;
        }
        else{
            return "wrong password";
        }
    }

    @Override
    public Double calculateTotalInterest(int time) {
        double simpleinterest =(balance*time*rateOfInterest)/100;
        return simpleinterest;
    }
}
