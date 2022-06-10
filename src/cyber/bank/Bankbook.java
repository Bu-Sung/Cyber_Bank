
package cyber.bank;

// 작성자 : 이수진
// 클래스 사용 이유 : 통장 종류 중 입출금 통장을 확인
class Bankbook implements Account_Type {
  public String type() {
      return "입출금통장";
  }

}
