
package user.create_card;

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
