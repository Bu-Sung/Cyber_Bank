
package cyber.bank;

// 작성자 : 이수진
// 클래스 사용 이유 : 계좌 개설할 때 카드를 개설할 수 있다는 것 반환

class With_Card implements With_Or_Without_Card {
  public String card() {
      return "yes";
  }

}
