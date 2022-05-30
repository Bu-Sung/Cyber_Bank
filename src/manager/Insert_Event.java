package manager;





import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;

class Insert_Event implements Subject {
    private Date date;
    private String datetostr;
    private String title;
    private String writer;
    private String news;
    private LinkedList<Observer> list;
    
    public Insert_Event(){
        list = new LinkedList<Observer>();
        
    }
    
    public void addNews(String title, String news, String writer) {
        date  = new Date();
        datetostr = date.toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE);
        datetostr = datetostr.substring(0, datetostr.length()-1);//날짜 마지막에 Z도 함께 저장되어서 제거
        this.title = title;
        this.writer = writer;
        this.news = news;
        notifyObservers();
    }

    public void notifyObservers() {
        for(int i=0;i<list.size();i++){
            list.get(i).update(datetostr, title, news, writer);
        }
    }

    public void registerObserver(Observer o) {
        list.add(o);
    }

    public void removeObserver(Observer o) {
        int i = list.indexOf(o);
        if(i>=0)
            list.remove(i);
    }
}
