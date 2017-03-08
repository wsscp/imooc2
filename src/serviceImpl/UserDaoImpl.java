package serviceImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.UsersDao;
import db.MyHibernateSessionFactory;
import entity.Users;


public class UserDaoImpl implements UsersDao{

	@Override
	public boolean userLogin(Users u) {
		
		//事物对象
		Transaction transaction=null;
		String hql = "";
		try {
//			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			Session session=MyHibernateSessionFactory.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			hql="from Users where username=? and password=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list=query.list();//查出数据，存到list集合，返回List类型
//			u.setUid(1);
//			u.setUsername("lisi");
//			u.setPassword("1234");
//			session.save(u);
			
			transaction.commit();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally{
			
			if(transaction!=null){
//				transaction.commit();
				transaction=null;
			}
			
		}
	}

}
