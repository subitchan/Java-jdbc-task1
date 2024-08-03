package com.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.id=123;
		emp.ename="subi";
		emp.sal=10000;
		emp.doj="2024-12-29";
		emp.dob="1999-02-19";
		emp.des="Sivakasi";
		emp.dept="CSE";
		emp.address="4/516f1 T.nagar";
		try {
			emp.setPhoto(new FileInputStream("C:\\Users\\chan\\Downloads\\download (1).jpeg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	PreparedStatement pst=null;
	Connection con=null;
	ResultSet rs=null;
	
	 try 
     {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsbdb","root","root");
      }
    catch (ClassNotFoundException e)
    {
        e.printStackTrace();
    }
    catch(SQLException e)
    {
    	e.printStackTrace();
    	}
	 
	 String sql="insert into Em(Address,Dept,Des,Ename,Photo,Dob,Doj,Id,Sal) values(?, ?, ?,?,?,?,?,?,?)";
 	  try {
 	   pst=con.prepareStatement(sql);
 	   pst.setString(1,emp.getAddress());
 	   pst.setString(2,emp.getDept());
 	   pst.setString(3,emp.getDes());
 	 pst.setString(4,emp.getEname());
 	 pst.setBlob(5,emp.getPhoto());
 	 pst.setString(6,  emp.getDob());
 	pst.setString(7,emp.getDoj());
	 pst.setInt(8,emp.getId());
	 pst.setFloat(9,emp.getSal());
 	
 	 
 	   pst.executeUpdate();
 	   }
 	  catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
