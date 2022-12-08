import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BankAccount {
  protected String name;
  private String accountNumber;
  protected Float balance;
  private List<String> transactions;
  private boolean closed;
  private Date dateCreated;
  private Date dateClosed;

  
// Getters and Setters
  public String getName() {
    return name;
  }
  // public void setName(String name) {
  //   this.name = name;
  // }
  public String getAccountNumber() {
    return accountNumber;
  }
  // public void setAccountNumber(String accountNumber) {
  //   this.accountNumber = accountNumber;
  // }
  public Float getBalance() {
    return balance;
  }
  public void setBalance(Float balance) {
    this.balance = balance;
  }
  public List<String> getTransactions() {
    return transactions;
  }
  public void setTransactions(List<String> transactions) {
    this.transactions = transactions;
  }
  public boolean isClosed() {
    return closed;
  }
  public void setClosed(boolean closed) {
    this.closed = closed;
  }
  public Date getDateCreated() {
    return dateCreated;
  }
  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }
  public Date getDateClosed() {
    return dateClosed;
  }
  public void setDateClosed(Date dateClosed) {
    this.dateClosed = dateClosed;
  }

  //Constructor
  public BankAccount(String name){
    this.name = name;
    this.accountNumber = generateAccountNumber();
    this.balance = 0.0f;
    this.transactions= new ArrayList<String>();
    this.closed = false;
    this.dateCreated = this.getCurrentDate();
    this.dateClosed = null;
  }
  public BankAccount(String name, Float balance){
    this.name = name;
    this.accountNumber = generateAccountNumber();
    this.balance = balance;
    this.transactions= new ArrayList<String>();
    this.closed = false;
    this.dateCreated = this.getCurrentDate();
    this.dateClosed = null;
  }

  // Generate Account Number (10-digits)
  public String generateAccountNumber(){
    String ac="";
    for(int i=0;i<10;i++){
      Random random = new Random();
      Integer randomNo = random.nextInt(10);
      ac+=randomNo.toString();
    }
    return ac;
  }

  // Current Date
  public Date getCurrentDate(){
    Date currentDate = new Date();
    return currentDate;
  }

  // Depposit Method
  public void deposit(Float amount){
    if(amount>0){
      Float currentBalance = this.getBalance();
      currentBalance+=amount;
      this.setBalance(currentBalance);
      List<String> transactionLog = this.getTransactions();
      transactionLog.add(String.format("deposit %f at %s",amount,new Date().toString()));
      this.setTransactions(transactionLog);
    }else{
      throw new IllegalArgumentException();
      }
    }
  
  // Withdraw Method
    public void withdraw(Float amount){
      if(amount>0){
        Float currentBalance = this.getBalance();
        currentBalance-=amount;
        this.setBalance(currentBalance);
        List<String> transactionLog =this.getTransactions();
        transactionLog.add(String.format("withdraw %f at %s", amount, new Date().toString()));
        this.setTransactions(transactionLog);
      }
      else{
        throw new IllegalArgumentException();
      }
    }
    
  }

