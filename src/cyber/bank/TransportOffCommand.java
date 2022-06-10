
package cyber.bank;

// 작성자 : 박채빈
// 클래스 사용 이유 : 교통 카드 기능을 사용하지 않는 것을 반환하는 커맨드

public class TransportOffCommand implements Command {
  private Transport mTransport;

  public TransportOffCommand(Transport transport) {
      mTransport = transport;
  }

  public void execute() {
      mTransport.off();
  }

}
