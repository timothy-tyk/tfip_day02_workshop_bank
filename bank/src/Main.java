public class Main {
  public static void main(String[] args) {
    BankAccount firstAccount = new BankAccount("Tim1", 10000f);
    firstAccount.deposit(2000.0f);
    firstAccount.withdraw(1000.0f);
    System.out.println(firstAccount.getBalance().toString());

    FixedDepositAccount fdAccount = new FixedDepositAccount("Tim2", 10000f, 0.05f, 12);
    System.out.println(fdAccount.getBalance());
  }
}
