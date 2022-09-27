package com.company.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.bean.Company;
import com.company.connection.MyConnection;

public class CompanyDao {
	public int addCompany(Company company) {
		int i = 0;
		Statement statement = null;
		Connection connection = null;
		try {
			connection = MyConnection.getConnection();
			statement = connection.createStatement();
			int vcid = company.getcId();
			String vName = company.getName();
			long vTurnOver = company.getTurnOver();
			String vAdress = company.getAddress();
			String vDate = company.getDateOfEstb();
//			String sql = "INSERT INTO COMPANY VALUES(109,'COGNIZANT',20000000,'BANGLORE','1998-12-11')";
			String sql = "INSERT INTO COMPANY VALUES('"+ vcid +"','"+ vName +"','"+ vTurnOver +"','"+ vAdress +"','"+ vDate+"')";
			i = statement.executeUpdate(sql);
		} catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}
	
	public int updateCompany(Company company) {
		int i = 0;
		Statement statement = null;
		Connection connection = null;
		try {
			connection = MyConnection.getConnection();
			statement = connection.createStatement();
			int vcid = company.getcId();
			String vName = company.getName();
			long vTurnOver = company.getTurnOver();
			String vAdress = company.getAddress();
			String vDate = company.getDateOfEstb();
			String sql = "UPDATE COMPANY SET  NAME = '" + vName + "' WHERE C_ID = " + vcid; 
			i = statement.executeUpdate(sql);
		} catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}
	
	public Company getCompanyById(int cid) {
		int i = 0;
		Statement statement = null;
		Connection connection = null;
		Company company = new Company();
		ResultSet res = null;
		try {
			connection = MyConnection.getConnection();
			statement = connection.createStatement();
			String sql = "SELECT * FROM COMPANY WHERE C_ID = " + cid;
			res = statement.executeQuery(sql);
			if(res.next()) {
				company.setcId(res.getInt(1));
				company.setName(res.getString(2));
				company.setTurnOver(res.getLong(3));
				company.setAddress(res.getString(4));
				company.setDateOfEstb(res.getString(5));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return company;
	}
	
	public List<Company> getAllCompany() {
		int i =0;
		Statement statement = null;
		Connection connection = null;
		List<Company> companyList = new ArrayList<Company>();
		ResultSet res = null;
		try {
			connection = MyConnection.getConnection();
			statement = connection.createStatement();
			String sql = "SELECT * FROM COMPANY";
			res = statement.executeQuery(sql);
			if(res.next()) {
				do {
					Company company = new Company();
					company.setcId(res.getInt(1));
					company.setName(res.getString(2));
					company.setTurnOver(res.getLong(3));
					company.setAddress(res.getString(4));
					company.setDateOfEstb(res.getString(5));
					
					companyList.add(company);
				}while(res.next());
			}else {
				System.out.println("Please try again");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return companyList;
	}

}
