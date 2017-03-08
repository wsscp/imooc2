package action;

import com.opensymphony.xwork2.ModelDriven;

import service.UsersDao;
import serviceImpl.UserDaoImpl;


import entity.Users;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user=new Users();
	
	public String login(){
		UsersDao udao=new UserDaoImpl();
		if(udao.userLogin(user)){
			return "login_success";
		}else{
			return "login_failure";
		}
		
	}
	
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
