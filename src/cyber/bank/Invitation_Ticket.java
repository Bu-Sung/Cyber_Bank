package cyber.bank;

// 작성자 : 김부성
// 클래스 사용 이유 : 사용자 혜택 중 연말 행사 초대권을 부여하는 클래스

class Invitation_Ticket extends Level_Benefits {
    @Override
    public String getBenefits() {
      return "연말 행사 초대권";
  }

}
