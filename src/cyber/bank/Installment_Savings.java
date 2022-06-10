
package cyber.bank;

// 작성자 : 이수진
// 클래스 사용 이유 : 통장의 종류가 적금 통장이라는 것을 반환

class Installment_Savings implements Account_Type {
  public String type() {
      return "적금통장";
  }

}
