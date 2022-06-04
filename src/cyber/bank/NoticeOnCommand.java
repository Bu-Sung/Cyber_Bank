
package cyber.bank;

public class NoticeOnCommand implements Command {
  private Notice mNotice;

  public NoticeOnCommand(Notice notice) {
      mNotice = notice;
  }

  public void execute() {
      mNotice.on();
  }

}
