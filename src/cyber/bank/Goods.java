package cyber.bank;

// 작성자 : 김부성
// 클래스 사용 이유 : 등급에 따른 굿즈증정 혜택을 추가하는 클래스

class Goods extends Level_Benefits {
    @Override
    public String getBenefits() {
      return "melon 굿즈 증정";
    }

}
