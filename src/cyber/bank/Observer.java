package cyber.bank;


// 작성자 : 김부성
// 클래스 사용 이유 : 공지사항에 대한 옵저버들의 정보 업데이트를 위한 옵저버 인터페이스

interface Observer {
    // 공지사항 등급에 해당되는 리스트에 새로운 공지사항을 업데이트 시킨다
    void update(String datetostr, String title) ;
}
