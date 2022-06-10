package cyber.bank;

import java.util.LinkedList;

// 작성자 : 김부성
// 클래스 사용 이유 : 관리자가 공지사항을 등록하면 옵저버들에게 알리는 클래스

class Insert_Event implements Subject {
  
    private String date; //작성 날짜
    private String title; //제목
    private LinkedList<Observer> list;
    
    public Insert_Event(){ //옵저버의 리스트를 생성하고 함수 사용을 위한 생성자
        list = new LinkedList<Observer>();
    }
    
    public void addNews(String date, String title) { //관리자가 공지사항 추가시 실행
        this.date=date; 
        this.title = title;
        notifyObservers(); //각 등급별 객체 리스트에 저장
    }

    public void notifyObservers() {
        //이전 관리자가 선택한 등급 list에 있는 등급들에 공지사항 목록 업데이트
        for(int i=0;i<list.size();i++){
            list.get(i).update(date, title);
        }
    }

    public void registerObserver(Observer o) {
        //업데이트를 진행할 리스트에 등급 옵저버 추가
        list.add(o);
    }
}
