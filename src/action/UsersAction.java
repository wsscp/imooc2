package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

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
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else{
			return "login_failure";
		}
		
	}
	
	@SkipValidation
	//用户退出方法
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			 session.removeAttribute("loginUserName");	
		}
		return "logout_success";
	}
	
	@Override
	public void validate() {
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空");
		}
		
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "密码不能少于六位");
		}
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
