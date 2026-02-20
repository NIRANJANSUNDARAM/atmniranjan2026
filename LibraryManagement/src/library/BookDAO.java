package library;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BookDAO {

public void addBook(Book book) {
try(Connection conn=DBConnection.getConnection())
{
	String sql="INSERT INTO books(title,author,price) Values(?,?,?)";
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setString(1,book.gettitle());
	ps.setString(2,book.getauthor());
	ps.setDouble(3,book.getprice());
	ps.executeUpdate();
	System.out.println("Books Added Success");
}catch(Exception e)
{
	e.printStackTrace();
}
}

public void viewBooks() {
try(Connection conn=DBConnection.getConnection())
{
	String sql="SELECT * FROM books";
	PreparedStatement ps=conn.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	System.out.println("-----Books List-----");
	while(rs.next())
	{
		System.out.println(rs.getInt("id")+"|"+rs.getString("title")+"|"+rs.getString("author")+"|"+rs.getDouble("price"));
	}
}catch(Exception e)
{
	e.printStackTrace();
}
}

}