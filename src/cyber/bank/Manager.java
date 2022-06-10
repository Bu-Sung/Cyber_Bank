/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber.bank;

// 작성자 : 김부성
// 클래스 사용 이유 : 관리자의 정보를 저장하는 클래스

public class Manager {
    private String id;
    private String name;
    
    public Manager(String id, String name) {
            this.id = id;
            this.name = name;
        }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    

}
