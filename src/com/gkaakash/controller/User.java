package com.gkaakash.controller;

import org.xmlrpc.android.XMLRPCException;

import android.os.Message;

import com.gkaakash.coreconnection.CoreConnection;

public class User {
	private CoreConnection conn;
	String setuser;
	boolean isuserexist,isuserunique,isadmin;
	Object[] getUserRole;
	
	/**
	 * default constructor   
	 * connect to server
	 */
	public User() {
		conn = new CoreConnection();
	}
	
	/**
	 * setuser() method to add user details while signup new user
	 * @param params takes firstname,lastname,username,password,userrole,mobileno,emailid
	 * @param client_id
	 * @return String 
	 */
	public String setUser(Object[] params,Object client_id)
	{
		try {
			setuser = (String)conn.getClient().call("user.setUser",params,client_id);
		} catch (XMLRPCException e) {
			
			e.printStackTrace(); 
		}
		System.out.println("user: "+setuser);
		return setuser;
	}
	/**
	 * isUseExist() method to check username and password validation 
	 * it call isUserExist method ``user`` module of ABTcore.
	 * @param params
	 * @param client_id
	 * @return if usename and password matches then return ``true`` else ``false``
	 */
	public boolean isUserExist(Object[] params,Object client_id)
	{
		try {
			isuserexist = (Boolean) conn.getClient().call("user.isUserExist",params,client_id);
		} catch (XMLRPCException e) {
			
			e.printStackTrace();
		}
		System.out.println("user: "+isuserexist);
		return isuserexist;
		
	}
	/**
	 * isUserUnique() method to check whether given user name already exist.
	 * It calls isUserUnque method from ``user`` module of ABTcore.
	 * @param params contain username
	 * @param client_id
	 * @return if username is already exist return true else false
	 */
	public boolean isUserUnique(Object[] params,Object client_id)
	{
		try {
			isuserunique = (Boolean) conn.getClient().call("user.isUserUnique",params,client_id);
		} catch (XMLRPCException e) {
			
			e.printStackTrace();
		}
		return isuserunique;
	}
	/**
	 * isAdmin() method to check whether current organisation has admin role
	 * It will call isAdmin method from ``user`` module of ABTcore
	 * @param client_id
	 * @return boolean true if admin role is present else false
	 */
			
	public boolean isAdmin(Object client_id)
	{
		try {
			isadmin = (Boolean) conn.getClient().call("user.isAdmin",client_id);
		} catch (XMLRPCException e) {
			
			e.printStackTrace();
		}
		return isadmin;
	}
	/**
	 * 		
	 * @param params
	 * @param client_id
	 * @return
	 */
	public Object[] getUserRole(Object[] params,Object client_id)
	{
		try {
			getUserRole = (Object[]) conn.getClient().call("user.getUserRole",params,client_id);
		} catch (XMLRPCException e) {
			
			e.printStackTrace();
		}
		return getUserRole;
	}	
		
	
}