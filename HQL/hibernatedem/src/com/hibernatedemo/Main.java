package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
    	SessionFactory factory = new Configuration()
    	        .configure("/com/hibernatedemo/hibernate.cfg.xml")
    	        .addAnnotatedClass(City.class)
    	        .buildSessionFactory();


        
        Session session = factory.getCurrentSession();

        try {
            //Insert
            session.beginTransaction();
            City citys = new City();
            citys.setName("Bursa");
            citys.setCountrycode("TUR");
           citys.setDistrict("Marmara");
            citys.setPopulation(10000);
             session.save(citys);
             System.out.println("Şehir Eklendi....");
             System.out.println("--------------------------------------------------------------");
             
             
             //Update
           City c = session.get(City.class,3357 );
           System.out.println(c.getName());
           c.setPopulation(10000);
           session.save(c);
           System.out.println("Şehir Güncellendi");
          
           
           
           //Delete
           City ci = session.get(City.class, 4080);
           session.delete(ci);
           
          System.out.println(ci +  	"Silindi");
             
             
             
             
             {
            	 }
             
            
            // Şehirleri sorgu ile çekme
            List<City> cities = (ArrayList<City>) session.createQuery("from City c where c.countrycode='TUR' ORDER BY c.name").getResultList();

            // Şehirleri ekrana yazdırma
            for (City city : cities) {
                System.out.println(city.getName());
            }

            
            session.getTransaction().commit();
        } finally {
            // Session ve factory kapatılıyor
            session.close();
            factory.close();
        }
    
}
}



