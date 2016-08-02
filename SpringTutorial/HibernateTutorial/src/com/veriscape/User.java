package com.veriscape;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


public class User {
	private final String userName;
	private final String userPass;
	private final boolean isAdmin;
	private final String adminName;

	public static String EMAIL_PATTERN= "^(.+)@(.+)$";
	public static String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";
	
	public User(){
		this.userName = "";
		this.userPass = "";
		this.isAdmin = false;
		this.adminName = "";
	}

	public User(String userName, String userPass, final DBUser user){
		this.userName = userName;
		this.userPass = userPass;
		//this.adminName = "";
		//isAdmin = false;
		if(userName.equals(user.getName())){
			this.isAdmin = true;
			this.adminName = userName;
		}else{
			this.isAdmin =false;
			this.adminName = "";
		}
	}

	public User(final HttpServletRequest request, final DBUser user){
		if(request.getParameter("userPass") != null && request.getParameter("username")!=null){
			this.userName = (String)request.getParameter("username");
			this.userPass = (String)request.getParameter("userPass");
			//parse response object for name/pass
			if(userName != null && userName.equals(user.getName())){
				this.isAdmin = true;
				this.adminName = userName;
			} else{
				this.isAdmin = false;
				this.adminName = "";
			}
		}else{
			this.userName = "";
			this.userPass = "";
			this.isAdmin = false;
			this.adminName = "";
		}
	}

	public UserAdmin getAdmin(){
		if(this.isAdmin){
			return new UserAdmin(this.adminName);
		}
		return null;
	}

	public void setUserName(RoleUser user)throws UnknownUserException{
		if(user.getName() != user) throw new UnknownUserException("Must be role user");
	}
	
	public boolean checkValidations(){
		boolean validation = true;
		if(!patternMatches(this.userName, EMAIL_PATTERN)){
			System.out.println("Invalid Username");
		}
		if(!patternMatches(this.userPass, PASSWORD_PATTERN)){
			System.out.println("Invalid Password");
		}
		return validation;
	}
	
	public boolean patternMatches(String line, String pattern)
	{
		boolean validated = false;
		Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.matches()) {
			validated = true;
		} 
		return validated;
	}
}
