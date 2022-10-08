package tn.esprit.business;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import tn.esprit.entites.Logement;
import tn.esprit.entites.RendezVous;


public class RendezVousBusiness {
	
	
	List<RendezVous> listeRendezVous = new ArrayList<>();
	LogementBusiness logementMetier=new LogementBusiness();
	
	
	public RendezVousBusiness() {
		
	
	}
	
	public boolean addRendezVous(RendezVous rendezVous){
		int refLogement=rendezVous.getLogement().getReference();
		Logement logement=logementMetier.getLogementsByReference(refLogement);
		if(logement!=null){
			rendezVous.setLogement(logement);
			return listeRendezVous.add(rendezVous);}
		return false;
	}
	
	
	
	public boolean updateRendezVous(int idRendezVous, RendezVous rendezVous){
		for(RendezVous r:listeRendezVous){
			if(r.getId()==idRendezVous){
				int index=listeRendezVous.indexOf(rendezVous);
				Logement logement=logementMetier.getLogementsByReference(rendezVous.getLogement().getReference());
				if(logement!=null){
					listeRendezVous.set(index, rendezVous);
					return true;
				}	
			}
		}
		return false;
	}
	
	
	public RendezVous getRendezVousById(int id){
		RendezVous rendezVous=null;
		for(RendezVous r:listeRendezVous){
			if(r.getId()==id)
				rendezVous=r;
		}
		return rendezVous;
	}
	
	public boolean deleteRendezVous(int id){
		Iterator<RendezVous> iterator=listeRendezVous.iterator();
		while(iterator.hasNext()){
			RendezVous r=iterator.next();
			if(r.getId()==id){
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public List<RendezVous> getListeRendezVous() {
		return listeRendezVous;
	}

	public void setListeRendezVous(List<RendezVous> listeRendezVous) {
		this.listeRendezVous = listeRendezVous;
	}
	
	public List<RendezVous> getListeRendezVousByLogementReference(int reference) {
		List<RendezVous> liste=new ArrayList<RendezVous>();
		for(RendezVous r:listeRendezVous){
			if(r.getLogement().getReference()==reference)
				liste.add(r);
		}
		return liste;
	}
	
	
	
	

}
