package cyber.bank;


import cyber.bank.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// 작성자 : 김부성, 손진제
// 클래스 사용 이유 : 계좌의 잔액 변화로 인한 고객의 총 계좌 잔액에 따른 등급 변경 인터페이스

public interface State {
    //변화된 고객의 상태에 따라 등급을 DB에 저장된 등급을 변환하여 준다.
    public void changeLevel(User user);
}
