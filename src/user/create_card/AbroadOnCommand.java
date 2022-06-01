
package user.create_card;

public class AbroadOnCommand implements Command {
  private Abroad mAbroad;

  public AbroadOnCommand(Abroad abroad) {
      mAbroad = abroad;
  }

  public void execute() {
      mAbroad.on();
  }

}
