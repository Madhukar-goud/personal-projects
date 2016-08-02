package com.veriscape;

public class RoleUser {
	private String userName;
	
	public RoleUser(){
		
	}

	public RoleUser getName() {
		
		return null;
	}

	@Override
	public String toString() {
		return "RoleUser [userName=" + userName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleUser other = (RoleUser) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	

}
