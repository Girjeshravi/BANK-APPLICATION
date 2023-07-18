package banking;

public class LotakBank implements RBIBankInterface{

    private String accNo;
    private String passCode;
    private double balance;
    private double rateOfInterest=7.5;

    public LotakBank(String accountNo,String password,double balance){
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
        if(password.equals(this.passCode)){
            if(balance>money){
                balance=balance-money;
                return "Mpney "+ money+"has been withdrawn. Remaining ";
            }else{
                return "Insufficient Balance";
            }
        }
        else{
            return "Wrong password";
        }
    }

    @Override
    public String checkBalance(String password) {
        if(password.equals(this.passCode)){
            return "THE BALNCE IS "+this.balance;
        }
        else{
            return "wrong password";
        }
    }

    @Override
    public Double calculateTotalInterest(int time) {
        double simpleinterest=(balance*time*rateOfInterest)/100;
        return simpleinterest;
    }
}
