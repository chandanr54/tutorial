package com.chandan.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandan.model.Teacher;

public class test {

	public static void main(String[] args) {
		//load conf file
		Configuration cf =new Configuration();
		cf.configure("hiber.cfg.xml");
		System.out.println(cf);
			
		SessionFactory sf= cf.buildSessionFactory();
		 System.out.println(sf);
		 
		 Teacher t1=new Teacher();
		 t1.setId(4);
		 t1.setName("Parvind");
		 t1.setCompany("CG");
		 
		 Session ss=sf.openSession();
		 //ss.persist(t1);
		 //ss.save(t1);
		 ss.saveOrUpdate(t1);
		 ss.beginTransaction().commit();
		 System.out.println("Succfull insert");
	}

 }
