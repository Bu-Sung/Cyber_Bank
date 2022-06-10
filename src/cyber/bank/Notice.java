
package cyber.bank;

// 작성자 : 박채빈
// 클래스 사용 이유 : 카드 사용시 알람 기능을 사용 여부를 수신

public class Notice {
  public Notice() {
  }

  public String on() {   // 알림 기능 사용
      return "on";
  }

  public String off() {   // 알림 기능 미사용
      return "off";
  }

}
