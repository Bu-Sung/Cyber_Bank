
package cyber.bank;

// 작성자 : 이수진
// 클래스 사용 이유 : 통장 종류 중 주택청약 통장이라는 것을 반환하는 클래스

class Housing_Subscription_Account implements Account_Type {
    public String type(){
        return "주택청약통장";
    }

}
