package ch08;

import java.time.LocalDate;

public class Customer {
	
	private String uid;
	private String uname;
	private LocalDate regDate;
	private int isDeleted;
	
	public Customer(String uid, String uname, LocalDate regDate, int isDeleted) {
	
		this.uid = uid;
		this.uname = uname;
		this.regDate = regDate;
		this.isDeleted = isDeleted;
	}
	
	
	
	public Customer(String uid, String uname) {
		this.uid = uid;
		this.uname = uname;
	}



	public Customer() {
	}

	
	@Override
	public String toString() {
		return "Customer [uid=" + uid + ", uname=" + uname + ", regDate=" + regDate + ", isDeleted=" + isDeleted + "]";
	}	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


	
	
	

}