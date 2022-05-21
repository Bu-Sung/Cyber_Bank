package manager.benefits;

import java.util.LinkedList;

class Vip extends User_Level {
 
    public Vip(LinkedList l) {//등급 값을 저장
        level= "Vip";
        benefits = l;
    }   
}
