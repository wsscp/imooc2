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
	//�û��˳�����
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			 session.removeAttribute("loginUserName");	
		}
		return "logout_success";
	}
	
	@Override
	public void validate() {
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "�û�������Ϊ��");
		}
		
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "���벻��������λ");
		}
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
