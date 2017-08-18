package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn2;
import com.test.dto.Page;
import com.test.dto.Vendor;

public class VendorService {
public List<Vendor> selectVendorList2(){
	Connection con=null;
	PreparedStatement ps=null;
	try{
		String sql="select vinum, viname from vendor_info";
		con=DBConn2.getCon();
		ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<Vendor> vendorList=new ArrayList<Vendor>();
		while(rs.next()){
			Vendor vendor = new Vendor();
			vendor.setViNum(rs.getInt("vinum"));
			vendor.setViName(rs.getString("viname"));
			vendorList.add(vendor);
		}
		return vendorList;
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		try{
			ps.close();
			DBConn2.closeCon();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return null;
}

	public List<Vendor> selectVendorsList(Vendor pVendor){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone from vendor_info where 1=1";
			int idx=0;
			if(pVendor.getViNum()!=0){
				sql += " and vinum=?";
				idx++;
			}
			if(pVendor.getViName()!=null){
				sql += " and viname like ?";
				idx++;
			}
			sql +=" order by vinum";
			sql +=" limit ?,?";
			Page page=pVendor.getPage();
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			if(pVendor.getViNum()!=0 && pVendor.getViName()==null){
				ps.setInt(1, pVendor.getViNum());
			}else if(pVendor.getViNum()==0 && pVendor.getViName()!=null){
				ps.setString(1, "%" + pVendor.getViName() + "%");
			}else if(pVendor.getViNum()!=0 && pVendor.getViName()!=null){
				ps.setInt(1, pVendor.getViNum());
				ps.setString(2, "%" + pVendor.getViName() + "%");
			}
			ps.setInt(++idx, page.getStartRow());
			ps.setInt(++idx, page.getRowCnt());
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				vendorList.add(vendor);
			}
			return vendorList;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int getTotalCount(Vendor pVendor){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select count(1) "
					+ " from vendor_info "
					+ " where 1=1";
			if(pVendor.getViNum()!=0){
				sql+=" and vinum=?";
			}
			if(pVendor.getViName()!=null){
				sql += " and viname like ?";
			}
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			if(pVendor.getViNum()!=0 && pVendor.getViName()==null){
				ps.setInt(1, pVendor.getViNum());
			}else if(pVendor.getViNum()==0 && pVendor.getViName()!=null){
				ps.setString(1, "%" + pVendor.getViName() + "%");
			}else if(pVendor.getViNum()!=0 && pVendor.getViName()!=null){
				ps.setInt(1, pVendor.getViNum());
				ps.setString(2, "%" + pVendor.getViName() + "%");
			}
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int insertVendor(Vendor pVendor){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into vendor_info(viname, videsc, viaddress, viphone, vicredat, vicretim)";
			sql += " values(?,?,?,?,DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'))";
			con = DBConn2.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, pVendor.getViName());
			ps.setString(2, pVendor.getViDesc());
			ps.setString(3, pVendor.getViAddress());
			ps.setString(4, pVendor.getViPhone());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Vendor selectVendor(Vendor pVendor){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone "
					+ " from vendor_info "
					+ " where vinum=?";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pVendor.getViNum());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				return vendor;
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int deleteVendor(Vendor pVendor){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "delete from vendor_info where  vinum=?";
			con = DBConn2.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setInt(1, pVendor.getViNum());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int updateVendor(Vendor pVendor){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "update vendor_info";
			sql += " set viname=?,";
			sql += " videsc=?,";
			sql += " viaddress=?,";
			sql += " viphone=?";
			sql += " where vinum=?";
			con = DBConn2.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setString(1, pVendor.getViName());
			ps.setString(2, pVendor.getViDesc());
			ps.setString(3, pVendor.getViAddress());
			ps.setString(4, pVendor.getViPhone());
			ps.setInt(5,pVendor.getViNum());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
}
