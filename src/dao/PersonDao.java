package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import utils.Tools;
import entity.Person;

public class PersonDao {
	private  Connection conn ;
	private  PreparedStatement pstmt;
	private  ResultSet rs;

  public void add(Person p)throws Exception{
	  conn=Tools.getConnection();
	  String sql="insert into person(name,age,description) values(?,?,?)";
	  pstmt = (PreparedStatement) conn.prepareStatement(sql);
	 
	  pstmt.setString(1, p.getName());
      pstmt.setInt(2, p.getAge());
      pstmt.setString(3, p.getDescription());
      pstmt.executeUpdate();
     Tools.close(rs, pstmt, conn);
      
	  
  }

  public void update(Person p)throws SQLException{
	  conn=Tools.getConnection();
	  String sql = "update person set name=?,age=?,description=? where id=?";
	  pstmt = (PreparedStatement) conn.prepareStatement(sql);
	  pstmt.setString(1, p.getName());
      pstmt.setInt(2, p.getAge());
      pstmt.setString(3, p.getDescription());
      pstmt.setInt(4, p.getId());
      pstmt.executeUpdate();
      Tools.close(rs, pstmt, conn);
      
	  
  }


  public void delete(int id)throws SQLException{
	  conn=Tools.getConnection();
	  String sql = "delete from person where id=?";
	  pstmt = (PreparedStatement) conn.prepareStatement(sql);
	  pstmt.setInt(1, id);  
	  pstmt.executeUpdate();
      Tools.close(rs, pstmt, conn);
      
	  
  }


  public Person findById(int id) throws SQLException {
	  Person p = new Person();
	  conn=Tools.getConnection();
	  String sql = "select name,age,description from person where id=?";
	  pstmt = (PreparedStatement) conn.prepareStatement(sql);
	  pstmt.setInt(1, id);
	  rs=pstmt.executeQuery();
	  if(rs.next()){
           p.setId(id);
           p.setName(rs.getString(1));
           p.setAge(rs.getInt(2));
	       p.setDescription(rs.getString(3));
	  }
      Tools.close(rs, pstmt, conn);
      return p;
      
	  
  }

  public Map<Integer,Person>  findAll() throws SQLException {
	  Map<Integer,Person> persons=new HashMap<Integer, Person>();
	  conn=Tools.getConnection();
	  String sql = "select id,name,age,description from person";
	  pstmt = (PreparedStatement) conn.prepareStatement(sql);
	  
	  rs=pstmt.executeQuery();
	   
	  while(rs.next()){
		   Person p=new Person();
		   p.setId(rs.getInt(1));
           p.setName(rs.getString(2));
           p.setAge(rs.getInt(3));
	       p.setDescription(rs.getString(4));
	       persons.put(rs.getInt(1), p);
	  }
      Tools.close(rs, pstmt, conn);
      return persons;
	  
  }


}
