
package user.create_card;

public class AbroadOffCommand implements Command {
  private Abroad mAbroad;
  
  public AbroadOffCommand(Abroad abroad) {
      mAbroad = abroad;
  }

  public void execute() {
      mAbroad.off();
  }

}
