package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
	
	private static SessionFactory factory;
	//构造方法私有化，保证单例模式
	private MyHibernateSessionFactory() {
		
	}
	
	//共有静态方法，获得会话工厂对象
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
