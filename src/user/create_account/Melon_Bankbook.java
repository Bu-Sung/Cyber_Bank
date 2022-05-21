
package user.create_account;

import cyber.bank.Db;
import user.User;

class Melon_Bankbook extends Account {
  public Melon_Bankbook(){
      account_Type=new Bankbook();
      // card를 생성할 수 있는 상품
      with_Or_Without_Card=new With_Card();
  }  
    
  public String benefits() {
      return "멜론입출금";
  }

  public void create_Account(User user){
     this.user = user;
     //계좌번호 8자리 랜덤 생성
     int num=((int)(Math.random()*90000000)+10000000);
     accountNumber=Integer.toString(num);
     //db 삽입을 위한
     String sql="insert into account value('"+accountNumber+"', '"+user.getId()+"','"+ user.getName()+"','"+account_Type.type()+"','"+with_Or_Without_Card.card()+"','"+benefits()+"',0,0 )";
     Db db = new Db();
     db.apply_Sql(sql);
  }

   
}
