package com.sneppets.drools;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

import com.sneppets.model.Account;


public class DroolInitialiser {
	
	private static KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	private static KnowledgeBase kbase;
	private static StatelessKnowledgeSession ksession;
	public void initialiseDrools(){
		
		//Read the DRL file and add to the knowledge builder
		try{
			kbuilder.add(ResourceFactory.newClassPathResource("myrule.drl"), ResourceType.DRL);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//Check for any errors
		KnowledgeBuilderErrors kberrors = kbuilder.getErrors();
		
		if(kberrors.size() > 0){
			System.out.println("Some errors exists in KnowledgeBuilder");
			for(int i=0; i<kberrors.size(); i++){
				System.out.println(kberrors);
			}
			throw new IllegalArgumentException("Could not parse knowledge");
		}
		
		//Add knowledge to the knowledge base
		
		try{
			kbase = kbuilder.newKnowledgeBase();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Method to fire rules for account
	public Account runRulesForAccount(Account account){
		
		ksession = kbase.newStatelessKnowledgeSession();
		ksession.execute(account);		
		return account;
		
	}

}
