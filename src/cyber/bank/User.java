/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber.bank;

// 작성자 : 김부성
// 클래스 사용 이유 : 고객 객체의 정보를 저장하기 위한 클래스

public class User {
    private String id = null;
    private String name = null;
    private String level = null;
    private int total = 0;
 
    public User(String id, String name, String level, int total) {
        this.id = id;
        this.name = name;
        this.level=level;
        this.total=total;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    
}
