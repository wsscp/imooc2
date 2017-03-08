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
		
		//�������
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
			List list=query.list();//������ݣ��浽list���ϣ�����List����
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
