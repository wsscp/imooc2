package serviceImpl;

import org.junit.Assert;
import org.junit.Test;

import entity.Users;
import service.UsersDao;


public class TestUsersDaoImpl {
	
	@Test
	public void testUsersLogin(){ 
		Users users=new Users(1,"wslisi","123456");
		UsersDao daoImpl=new UserDaoImpl();
		Assert.assertEquals(true, daoImpl.userLogin(users));
	}

}
