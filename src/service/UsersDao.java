package service;

import entity.Users;

//用户业务逻辑接口
public interface UsersDao {
	
	//user login
	public boolean userLogin(Users u);
}
