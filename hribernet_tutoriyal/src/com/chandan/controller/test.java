package com.chandan.controller;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandan.model.Teacher;

public class test {

	public static void main(String[] args) {
		//load conf file
		Configuration cf =new Configuration();
		cf.configure("hiber.cfg.xml");
		//cf.configure(new File("C:\\user\\heart\\desktop\\hiber.cfg.xml"));
		System.out.println(cf);
			
		SessionFactory sf= cf.buildSessionFactory();
		 System.out.println(sf);
		 //Transient sate 
		 //thant means object not accosiate with session 
			/*
			 * Teacher t1=new Teacher(); t1.setId(4); t1.setName("Parvind");
			 * t1.setCompany("CG");
			 */
		 
		 Session ss=sf.openSession();
		 //persitances sate
		 //whwn object accosiate with  session 
		 
		 //ss.persist(t1);
		 //ss.save(t1);
		 //ss.saveOrUpdate(t1);
		 
		Teacher tt= ss.get(Teacher.class, 6);
		
		
		if(tt!=null )
		{
			System.out.println(tt.getName()+"\t"+tt.getCompany());
		}else {
			System.out.println("data not found");
		}
		
		 
		 ss.beginTransaction().commit();
		 //detaches sate
		 //when close the session then object is detached state
		 ss.close();
		 
		 System.out.println("Succfull insert");
	}

 }
