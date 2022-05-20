
package user.create_account;

abstract class Account {
    protected String accountNumber;
    protected Account_Type account_Type;
    protected With_Or_Without_Card with_Or_Without_Card;
    abstract String benefits();
    abstract void create_Account(String Id, String Pw);
}
