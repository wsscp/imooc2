package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
	
	private static SessionFactory factory;
	//���췽��˽�л�����֤����ģʽ
	private MyHibernateSessionFactory() {
		
	}
	
	//���о�̬��������ûỰ��������
	public static SessionFactory getSessionFactory(){
		if(factory==null){
			Configuration configuration=new Configuration().configure();
			
			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
			.applySettings(configuration.getProperties()).buildServiceRegistry();
			
			factory=configuration.buildSessionFactory(serviceRegistry);
			
			return factory;
			
		}else{
			return factory;
		}
		
	}

}
