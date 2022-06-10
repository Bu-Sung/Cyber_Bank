package cyber.bank;

// 작성자 : 김부성
// 클래스 사용 이유 : 등급별 혜택 중 캐시백 혜택을 가지는 클래스
class CashBack extends Level_Benefits {
    
    @Override
    public String getBenefits() {
        return "캐시백 5%";
    }
}
