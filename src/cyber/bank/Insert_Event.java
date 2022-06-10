package cyber.bank;

import java.util.LinkedList;

class Insert_Event implements Subject {
  
    private String date;
    private String title;
    private LinkedList<Observer> list;
    
    public Insert_Event(){
        list = new LinkedList<Observer>();
        
    }
    
    public void addNews(String date, String title) {
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
