package cyber.bank;




interface Subject {
    
  void registerObserver(Observer o) ;//옵저버 추가 함수
  
  void notifyObservers() ;//옵저버에게 공지사항 추가를 알리는 함수

}
