package atm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
public account getaccountnumber(String accountnumber)
{
	account acc=null;
	try(Connection conn=DBConnection.getConnection())
	{
		 String sql = "SELECT * FROM accounts WHERE account_number=?";
		 PreparedStatement ps=conn.prepareStatement(sql);
		 ps.setString(1, accountnumber);
		 ResultSet rs=ps.executeQuery();
		 if (rs.next()) {
             acc = new account(
                     rs.getString("account_number"),
                     rs.getDouble("balance")
             );
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
     return acc;
	}
public void updateBalance(String accountNumber, double balance) {
    try (Connection con = DBConnection.getConnection()) {

        String sql = "UPDATE accounts SET balance=? WHERE account_number=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, balance);
        ps.setString(2, accountNumber);

        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

