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
		
	//�������ö���
		Configuration config=new Configuration().configure();
	//�����������
		ServiceRegistry serviceRegistry= new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	//����session Factory
		SessionFactory sessionFactory=config.buildSessionFactory();
	//����session����
		Session session =sessionFactory.openSession();
	//shemaExportҪ�ع�Hibernate-coreʹ��hibernate4���µİ汾��5�Ĳ���
		SchemaExport export=new SchemaExport(config);
	export.create(true,true);
	}


}
