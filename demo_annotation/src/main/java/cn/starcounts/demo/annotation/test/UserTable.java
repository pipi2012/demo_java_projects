package cn.starcounts.demo.annotation.test;

import cn.starcounts.demo.annotation.Column;
import cn.starcounts.demo.annotation.Description;
import cn.starcounts.demo.annotation.Table;

@Table("user")
@Description(val="usertable")
public class UserTable {
	
	@Column(name="name",type="varchar",length=20)
	public String name;
	
	@Column(name="password",type="varchar",length=20)
	public String password;
	
	@Column(name="age",type="int")
	public int age;
	
	@Description(val="getuserinfomethod")
	public String getUserINfo() {
		return "UserTable [name=" + name + ", password=" + password + ", age=" + age + "]";
	}
	
}
