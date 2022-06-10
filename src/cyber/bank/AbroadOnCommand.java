
package cyber.bank;

// 작성자 : 박채빈
// 클래스 사용 이유 : 해외결제 기능을 사용할 때 커맨드
public class AbroadOnCommand implements Command {
  private Abroad mAbroad;

  public AbroadOnCommand(Abroad abroad) {
      mAbroad = abroad;
  }

  public void execute() {
      mAbroad.on();
  }

}
