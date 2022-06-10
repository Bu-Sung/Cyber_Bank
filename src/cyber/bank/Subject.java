package cyber.bank;

// 작성자 : 김부성
// 클래스 사용 이유 : 옵저버 패턴에서 신문사 역할을 하며 옵저버를 추가하고 이벤트 발생을 알리는 기능을 하는 인터페이스

interface Subject {
    
  void registerObserver(Observer o) ;//옵저버 추가 함수
  
  void notifyObservers() ;//옵저버에게 공지사항 추가를 알리는 함수

}
