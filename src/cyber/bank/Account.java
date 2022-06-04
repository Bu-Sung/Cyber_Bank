
package cyber.bank;

import cyber.bank.User;

abstract class Account {
    protected String accountNumber;
    protected Account_Type account_Type;
    protected With_Or_Without_Card with_Or_Without_Card;
    protected User user;
    abstract String benefits();
    abstract void create_Account(User user, String pw);
}
