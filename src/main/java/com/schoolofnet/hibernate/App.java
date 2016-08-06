package com.schoolofnet.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.schoolofnet.model.HibernateSession;
import com.schoolofnet.model.Product;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	Session session = HibernateSession.getSessionFactory().openSession();
    	
    	session.beginTransaction();
    	
    	Product p2 = new Product();
    	
    	p2.setName("P 3");
    	p2.setPrice(10.00);
    	
    	session.save(p2);
    	
    	Product product = session.find(Product.class, 6);
    	if (product != null) {
    		session.delete(product);
//    		session.remove(product);
    	}
    	
//    	Product product = new Product();
//    	
//    	product.setName("P 1");
//    	product.setPrice(10.00);
//    	
////    	session.save(product);
//    	
////    	List<Product> products = session.createQuery("from Product").getResultList();
//    	
//    	Product p1 = session.find(Product.class, 5);
//    	
//    	System.out.println(p1.getName());

    	session.getTransaction().commit();
    }
}
