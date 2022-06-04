/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber.bank;

import cyber.bank.User;

/**
 *
 * @author User
 */
//통장 생성에 메인 역할을 하는 클래스
public class Create_account {
    User user;
    String pw;
    String product;
    
    public Create_account(User user, String pw, String product){
        this.user=user;
        this.pw=pw;  
        this.product=product;
    }
    
    public void create(){
        if(product.equals("메론입출금")){
                Account b = new Melon_Bankbook();
                b.create_Account(user,pw);

            }else if(product.equals("예금")){
                Saving_Account b = new Saving_Account();
                b.create_Account(user,pw);
                
            }else if(product.equals("청년주택청약")){
                Youth_Housing_Subscription b = new  Youth_Housing_Subscription();
                b.create_Account(user,pw);
                
            }else if(product.equals("청년희망적금")){
                Youth_Hope_Savings b = new Youth_Hope_Savings();
                b.create_Account(user,pw);
                
            }
    }
}
