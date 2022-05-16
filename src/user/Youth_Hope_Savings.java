
package user;
import cyber.bank.Db;

class Youth_Hope_Savings extends Account {
  public Youth_Hope_Savings(){
    account_Type = new Installment_Savings();
    with_Or_Without_Card = new Without_Card();
  }
    
  public String benefits() {
      return "청년희망적금";
  }
  public void create_Account(String Id, String Name, String Pw, String Kind){
     //계좌번호 8자리 랜덤 생성
     int num=((int)(Math.random()*90000000)+10000000);
     accountNumber=Integer.toString(num);
     //db 삽입을 위한
     String sql="insert into accout value("+accountNumber+", "+Id+"," +Name+","+ Pw+","+Kind+","+with_Or_Without_Card.card()+","+account_Type.type()+"0,0 )";
     Db db = new Db();
     db.apply_Sql(sql);
  }

}
