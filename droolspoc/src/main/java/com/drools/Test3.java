package com.drools;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

public class Test3 {
	
	public static void main(String[] args) {
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kcontainer = ks.getKieClasspathContainer();
		KieSession kieSession = kcontainer.newKieSession("rulesSession");
		
		Room room = new Room();
		room.setName("A-101");
		

		Room r2 = new Room();
		r2.setName("A-102");

		Fire fire = new Fire();
		fire.setRoom(room);
		
		Sprinkler s = new Sprinkler();
		s.setRoom(room);
		s.setStatus(false);
		
		Sprinkler sp2 = new Sprinkler();
		sp2.setRoom(r2);
		sp2.setStatus(true);
		
		// insert the fact into working memory
		//kieSession.insert(room);
		kieSession.insert(fire);
		kieSession.insert(s);
		kieSession.insert(sp2);
		
		// fire all the rules present in production memory
		kieSession.fireAllRules();
		kieSession.dispose();
		//System.out.println("product discount ::-> "+product.getDiscount());
		System.out.println("rule execution end..");
	
	}

}
