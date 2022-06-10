package cyber.bank;


// 작성자 : 김부성
// 클래스 사용 이유 : 등급에 따른 혜택을 지정할 수 있도록 혜택을 반환해주는 추상클래스

abstract class Level_Benefits extends User_Level {
    abstract public String getBenefits();//각 혜택 값을 리턴
}
