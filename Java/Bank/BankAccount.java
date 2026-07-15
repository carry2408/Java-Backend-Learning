package Bank;

public class BankAccount {
        int balance =100;

        public synchronized void withdraw(int amt){
            System.out.println(Thread.currentThread().getName()+" is requesting for withdraw");
            if (amt<=balance) {
                System.out.println(Thread.currentThread().getName()+" Proceding with the withdraw");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                balance-=amt;
                System.out.println(Thread.currentThread().getName()+" withdraw of ammount "+amt+" succesfull\nAvailable balance is "+balance);
            }
            else{
                System.out.println(Thread.currentThread().getName()+" withdraw request cant be done because balance is low ");
            }
        }
}       
