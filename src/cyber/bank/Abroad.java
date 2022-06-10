
package cyber.bank;

// 작성자 : 박채빈
// 클래스 사용 이유 : 해외결제 기능 사용 여부를 수신
public class Abroad {
  public Abroad() {
  }

  public String on() {//해외 결제 기능 사용
      return "on";
  }

  public String off() {//해외 결제 기능 미사용
      return "off";
  }

}
