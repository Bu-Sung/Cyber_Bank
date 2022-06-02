
package user.create_card;

public class NoticeOffCommand implements Command {
  private Notice mNotice;

  public NoticeOffCommand(Notice notice) {
      mNotice = notice;
  }

  public void execute() {
      mNotice.off();
  }

}
