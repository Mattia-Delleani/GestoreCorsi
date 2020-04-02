package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private CorsoDAO dao;
	
	public Model() {
		dao = new CorsoDAO();
	}
	
	public boolean esisteCorso (Corso c) {
		return dao.esisteCorso(c);
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return dao.getCorsiByPeriodo(pd);
	}
	

	public Map<Corso,Integer> getIscrittiByPeriodo(Integer pd){
		return dao.getIscrittiByPeriodo(pd);
	}
	
	public List<Studente> getStudentiByCorso(Corso corso){
		return dao.getStudentiByCorso(corso);
	}
	
	public Map<String, Integer> getDivisioneCDS(Corso c){
		//SOLUZIONE CON JAVA
		/*
		List<Studente> studenti = dao.getStudentiByCorso(c);
		//uso hasMap peche le chiavi sono univoche
		Map<String, Integer> statistiche = new HashMap<>();
		
		for(Studente s:studenti) {
			
			if(s.getCDS()!= null && !s.getCDS().equals("")) {
				if(statistiche.containsKey(s.getCDS()))
					statistiche.put(s.getCDS(), statistiche.get(s.getCDS())+1);
				else
					statistiche.put(s.getCDS(), 1);
			
			}
		}
		return statistiche;
		 */
		
		//SOLUZIONE CON SQL dal DAO
		return dao.getDivisioneCDS(c);
		
	}
}
