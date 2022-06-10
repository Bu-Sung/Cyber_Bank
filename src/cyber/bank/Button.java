
package cyber.bank;

// 작성자 : 박채빈
// 클래스 사용 이유 : 고객이 카드 개설을 이용할 때 실행되는 호출자
public class Button {
    
  private Command mCommand;

  public Button() {
  }

  // 버튼 눌리면 Command의 execute 메소드 호출
  public void pressed() {
      mCommand.execute();
  }

  public void setCommand(Command command) {
      mCommand = command;
  }
}
