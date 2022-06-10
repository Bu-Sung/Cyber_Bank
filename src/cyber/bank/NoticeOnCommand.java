
package cyber.bank;

// 작성자 : 박채빈
// 클래스 사용 이유 : 카드 사용시 알림을 받는다는 커맨드

public class NoticeOnCommand implements Command {
  private Notice mNotice;

  public NoticeOnCommand(Notice notice) {
      mNotice = notice;
  }

  public void execute() {
      mNotice.on();
  }

}
