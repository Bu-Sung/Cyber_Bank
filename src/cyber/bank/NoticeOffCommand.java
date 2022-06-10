
package cyber.bank;

// 작성자 : 박채빈
// 클래스 사용 이유 : 카드 사용시 알림을 사용하지 않는다는 커맨드

public class NoticeOffCommand implements Command {
  private Notice mNotice;

  public NoticeOffCommand(Notice notice) {
      mNotice = notice;
  }

  public void execute() {
      mNotice.off();
  }

}
