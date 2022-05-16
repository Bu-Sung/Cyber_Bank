
package user;

abstract class Account {
    
  public String owner;

  protected int balance;

  protected String accountNumber;
  
  protected Account_Type account_Type;

  protected With_Or_Without_Card with_Or_Without_Card;


  
  abstract String benefits();
  
  abstract void create_Account(String Id, String Name, String Pw, String Kind);
}
