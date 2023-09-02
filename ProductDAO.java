package dao;
import java.sql.*;

import connectionmanager.ConnectionManager;
import model.product;

public class ProductDAO {
	public void addProduct(product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		String que ="insert into product(prodId,prodName,minSellQuantity,price,quantity) values(?,?,?,?,?)";
		//prepared statement It takes the input from run time.
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1, p.getProdId());
		ps.setString(2, p.getProdName());
		ps.setInt(3, p.getMinSellQuantity());
		ps.setInt(4, p.getPrice());
		ps.setInt(5,p.getQuantity());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void display() throws ClassNotFoundException, SQLException
	{
				
				//1.jdbc connection
				ConnectionManager cm=new ConnectionManager();
				Connection con=cm.establishConnection();
				
				//2.Create statement
				Statement st=con.createStatement();
				
				
				ResultSet rt= st.executeQuery("select * from product");
				
				//3.print
				while(rt.next())
				{
						System.out.println(rt.getInt("prodId")+" | "+rt.getString("prodName")+" | "+rt.getString("minSellQuantity")+" | "+rt.getString("price")+" | "+rt.getString("quantity"));
						
				}
	 }
	public void updateProduct(product p)throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="update product set prodName=?,minSellQuantity=?,price=?,quantity=? where ProdId=?";
		PreparedStatement ps =con.prepareStatement(que);
		ps.setInt(1,p.getProdId());
		ps.setString(2,p.getProdName());
		ps.setInt(3, p.getMinSellQuantity());
		ps.setInt(4, p.getPrice());
		ps.setInt(5,p.getQuantity());
		ps.executeUpdate();
		cm.closeConnection();
		
	}
	public void deleteproduct(product p)throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="delete from product where prodId=?";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1,p.getProdId());
		ps.executeUpdate();
		cm.closeConnection();
	}
}
