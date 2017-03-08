package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudents {
	@Test
	public void TestSchemaExport(){
		
	//创建配置对象
		Configuration config=new Configuration().configure();
	//创建服务对象
		ServiceRegistry serviceRegistry= new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	//创建session Factory
		SessionFactory sessionFactory=config.buildSessionFactory();
	//创建session对象
		Session session =sessionFactory.openSession();
	//shemaExport要重构Hibernate-core使用hibernate4以下的版本，5的不行
		SchemaExport export=new SchemaExport(config);
	export.create(true,true);
	}


}
