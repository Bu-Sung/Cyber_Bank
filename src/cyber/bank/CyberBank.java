/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber.bank;
/**
 *
 * @author User
 */
public class CyberBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        Db db = new Db();
        String sql1 = "insert into test value ('use')";
        
        db.apply_Sql(sql1);
        
    }
}
