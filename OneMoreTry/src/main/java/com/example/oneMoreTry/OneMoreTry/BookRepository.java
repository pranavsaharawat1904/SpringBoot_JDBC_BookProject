package com.example.oneMoreTry.OneMoreTry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mysql.cj.xdevapi.PreparableStatement;

@Repository
public class BookRepository {

	private static Logger logger = LoggerFactory.getLogger(BookRepository.class);
	Connection con;

	public BookRepository() throws SQLException {
		logger.info("Inside the constructor of a book Repository");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookproject_springBoot", "root", "system");
		if (con != null) {
			logger.info("Connection with the Database Establish Sucssfully");
			createTable();
		} else
			logger.error("Not able to connect with the Database");

	}

	public void createTable() {
		try {
			Statement st = con.createStatement();
			String query = "create table if not exists book( id int auto_increment primary key, name varchar(2455), author varchar(244), cost int)";
			int row = st.executeUpdate(query);
		} catch (Exception e) {
			logger.error("Something went wrong in Create Table: :" + e);
		}
	}

	public void insertBook(Book book) {
		logger.info("Inside the Repo class: insert Book Method");
		try {
			PreparedStatement pst = con.prepareStatement("insert into book(name,author,cost) values(?,?,?)");
			pst.setString(1, book.getName());
			pst.setString(2, book.getAuthor());
			pst.setInt(3, book.getCost());
			int rowCount = pst.executeUpdate();
			logger.info("Number of rows inserted:" + rowCount);

		} catch (Exception e) {
			logger.error("Soome issue in the Book Repo: Insert Book:" + e);
		}
	}

	public List<Book> getAllBooks() {
			List<Book> allBooks= new ArrayList<Book>();
		try
		{
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery("select * from book");
		while(rs.next())
		{
			int id =rs.getInt(1);
			String name=rs.getString(2);
			String author=rs.getString(3);
			int cost=rs.getInt(4);
			
			Book b= Book.builder()
					.id(id)
					.author(author)
					.name(name)
					.cost(cost)
					.build();
			allBooks.add(b);
		}
			
		
		}
			
			catch (Exception e) 
			{
				logger.error("Error in Book Repo:getAllBook :"+e);
					}
		return allBooks;
	}
	
	public Book getBookById(int id)
	{
		Book b = null;
		try {
			
			Statement st=con.createStatement();
			String query=("select * from book where id="+id);
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				int id1=rs.getInt(1);
				String name=rs.getString(2);
				String author=rs.getString(3);
				int cost=rs.getInt(4);
				b=Book.builder()
						.id(id1)
						.name(name)
						.author(author)
						.cost(cost)
						.build();
			}
			
		} catch (Exception e) {
			logger.error("Error in the Book Repo: getBookById :"+e);
		}
		return b;
	}
	
	public String deleteBook(int id)
	{
		String status="Not able to delete";
		try {
			
			Statement st=con.createStatement();
			int rowCount=st.executeUpdate("delete from book where id="+id);
			if(rowCount>0)
			{
				status="Book with Id  "+id+" is deleted Successfully"; 
			}
			
		} catch (Exception e) {
			logger.error("Some Issue in Book Repo: Delete :"+e);
		}
		return status;
	}
	
	public String updateBook(int id,Book book)
	{
		String status="Not able to Update";
		try {
			Statement st= con.createStatement();
			
			String query="update book set name='"+book.getName()+"', author='"+book.getAuthor()+"', cost="+book.getCost()+" where "
					+ "id="+id;
			int rowCount=st.executeUpdate(query);
			if(rowCount>0)
			{
				status="Update the Book details with the id="+id;
			}
			
		} catch (Exception e) {
			logger.error("Issue in Book Repo: Update Boook ::"+e);
		}
		return status;
	}

}
