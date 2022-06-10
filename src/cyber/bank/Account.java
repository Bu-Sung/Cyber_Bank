
package cyber.bank;

// 작성자 : 이수진
// 클래스 사용 이유 : 고객이 생성하는 통장 객체 클래스
abstract class Account { 
    protected String accountNumber; //계좌번호
    protected Account_Type account_Type; //통장의 종류
    protected With_Or_Without_Card with_Or_Without_Card; //카드 개설 가능 유무
    protected User user; // 고객정보
    abstract String benefits(); // 통장 종류의 따라 선택한 상품을 반환
    abstract void create_Account(User user, String pw);// 입력 받은 정보에 따라 통장 생성
}
