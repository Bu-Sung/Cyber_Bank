
package user.create_account;
import user.create_account.Account;
import cyber.bank.Db;

class Youth_Hope_Savings extends Account {
  public Youth_Hope_Savings(){
    account_Type = new Installment_Savings();
    with_Or_Without_Card = new Without_Card();
  }
    
  public String benefits() {
      return "청년희망적금";
  }
  public void create_Account(String Id, String Pw){
     //계좌번호 8자리 랜덤 생성
     int num=((int)(Math.random()*90000000)+10000000);
     accountNumber=Integer.toString(num);
     //db 삽입을 위한
     String sql="insert into account value('"+accountNumber+"', '"+Id+"','"+ Pw+"','"+account_Type.type()+"','"+with_Or_Without_Card.card()+"','"+benefits()+"',0,0 )";
     Db db = new Db();
     db.apply_Sql(sql);
  }

}