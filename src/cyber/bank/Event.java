/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber.bank;

/**
 *
 * @author User
 * 클래스 사용 이유 : 고객의 공지사항이 업데이트 되는 것을 확인하기 위해서
 */
public class Event {
    String date;
    String title;

    //고객의 공지사항 목록을 저장하는 생성자
    public Event(String date, String title) { 
        this.date = date;
        this.title = title;;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

}
