package com.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.model.*;
public class Jdbc {
	Connection con;
	PreparedStatement ps;
	int i;
	public Connection myConnection(){
		//1.load driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","bhargu20");
			System.out.println("Connection to db..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch connection..");
		} catch (SQLException e) {
			System.out.println("catch connection..2");
			e.printStackTrace();
		}
		return con;
	}
	public int saveData(List<Registration> lst){
		Registration r =  lst.get(0);
		
		try {
			con=myConnection();
			ps=con.prepareStatement("insert into reg values(?,?,?)");
			ps.setInt(1,r.getRegno());
			ps.setString(2,r.getUser());
			ps.setString(3,r.getPass());
			
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("test11");
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("global.."+e);
		}
		return i;
	}
	public int deleteRecord(int no){
		try {
			con=myConnection();
			ps=con.prepareStatement("delete from reg where empno=?");
			ps.setInt(1,no);
			i=ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public boolean searchRecord(List<Login> lst){
		Login l = lst.get(0);
		String str = "select * from reg";
		boolean res=false;
		try {
			con=myConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(str);

			
			
			while(rs.next())
			{
				System.out.println(rs.getString(2)+" "+rs.getString(3));
				System.out.println(l.getUsername()+" "+l.getPassword());
				if(rs.getString(2).equals(l.getUsername()) && rs.getString(3).equals(l.getPassword()))
				{
					res = true;
				}
				
			}
			
			
		
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(res);
		return res;
	}
	public List<Registration> displayAll(){
		String str="select * from reg";
		List<Registration> lst = new ArrayList<>();
		Registration r;
		try {
			con=myConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(str);

		//String s="<table><tr><th>Registration no</th><th>Username</th><th>Password</th></tr>";
			while(rs.next())
			{
				r = new Registration();
				//s +="<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>";
			r.setRegno(rs.getInt(1));
				r.setUser(rs.getString(2));
				r.setPass(rs.getString(3));
				
			lst.add(r);
			
				
			}
			//s+="</table>";
		
		//	con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;

	}
}

