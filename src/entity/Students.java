package entity;

import java.util.Date;

public class Students {
    private String sid;//Ñ§ºÅ
    private String name;
    private String gender;
    private Date brithday;
	private String Address;
	
	
	
	public Students(){
		
		
	}
	public Students(String sid, String name, String gemder, Date brithday, String address) {
		super();
		this.sid = sid;
		this.name = name;
		this.gender = gemder;
		this.brithday = brithday;
		Address = address;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", name=" + name + ", gemder=" + gender + ", brithday=" + brithday
				+ ", Address=" + Address + "]";
	}
	


}
