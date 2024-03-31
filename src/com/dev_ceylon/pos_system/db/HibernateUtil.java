package com.dev_ceylon.pos_system.db;

//import com.dev_ceylon.pos_system.entity.AccessPoint;
import com.dev_ceylon.pos_system.entity.User;
import com.dev_ceylon.pos_system.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;

public class HibernateUtil {

    public final static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory(){

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(UserRole.class)
                .addAnnotatedClass(User.class)
//                .addAnnotatedClass(AccessPoint.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

}