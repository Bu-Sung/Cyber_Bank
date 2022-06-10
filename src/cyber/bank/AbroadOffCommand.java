
package cyber.bank;

// 작성자 : 박채빈
// 클래스 사용 이유 : 해외결제 기능을 사용하지 않을 때 커맨드
public class AbroadOffCommand implements Command {
  private Abroad mAbroad;
  
  public AbroadOffCommand(Abroad abroad) {
      mAbroad = abroad;
  }

  public void execute() {
      mAbroad.off();
  }

}
