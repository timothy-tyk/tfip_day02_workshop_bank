public class FixedDepositAccount extends BankAccount {
  
  private Float interest;
  private Integer duration;
  private Integer interestChangeCount = 0;
  private Integer durationChangeCount = 0;

  //Getters and Setters
  public Float getInterest() {
    return interest;
  }
  public void setInterest(Float interest) {
    this.interest = interest;
  }
  public Integer getDuration() {
    return duration;
  }
  public void setDuration(Integer duration) {
    this.duration = duration;
  }
  public Integer getInterestChangeCount() {
    return interestChangeCount;
  }
  public void setInterestChangeCount(Integer interestChangeCount) {
    this.interestChangeCount = interestChangeCount;
  }
  public Integer getDurationChangeCount() {
    return durationChangeCount;
  }
  public void setDurationChangeCount(Integer durationChangeCount) {
    this.durationChangeCount = durationChangeCount;
  }

  //Change Interest Rate Method
  public void changeInterestRate(Float newRate){
    if(this.interestChangeCount<1){
      this.setInterest(newRate);
      this.setInterestChangeCount(this.interestChangeCount+1);
    }else{
      throw new IllegalArgumentException();
    }
  }  
  //Change Duration Method
  public void changeDuration(Integer newDuration){
    if(this.durationChangeCount<1){
      this.setDuration(newDuration);
      this.setDurationChangeCount(this.durationChangeCount+1);
    }
  }

  @Override
  public void withdraw(Float amount){
    System.out.println("NOP");
  }
  @Override
  public void deposit(Float amount){
    System.out.println("NOP");
  }
  @Override
  public Float getBalance(){
    Float accruedInterest = this.getInterest()*this.balance*(getDuration()/12);
    return this.balance + accruedInterest;
  }
  @Override
  public void setBalance(Float amount){
    System.out.println("NOP");
  }

  // Constructors
  public FixedDepositAccount(String name, Float balance){
    super(name, balance);
    this.interest = 0.03f;
    this.duration = 6;
  }
  public FixedDepositAccount(String name, Float balance, Float interest){
    super(name,balance);
    this.interest = interest;
    this.duration = 6;
  }
  public FixedDepositAccount(String name, Float balance, Float interest, Integer duration){
    super(name,balance);
    this.interest = interest;
    this.duration = duration;
  }

}
