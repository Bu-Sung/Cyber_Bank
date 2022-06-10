
package cyber.bank;

// 작성자 : 이수진
// 클래스 사용 이유 : 카드 개설시 카드 개설이 불가능 하다는 것을 반환

class Without_Card implements With_Or_Without_Card {
  public String card() {
      return "no";
  }

}
