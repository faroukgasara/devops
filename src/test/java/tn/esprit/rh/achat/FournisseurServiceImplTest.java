package tn.esprit.rh.achat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.IFournisseurService;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest

public class FournisseurServiceImplTest {
	
	
	
	@Autowired
	private IFournisseurService repo;
	
	
	@Test
	public void testCreateFournisseur() {
	Fournisseur prod = new Fournisseur( "100" ,"200");
	repo .addFournisseur( prod ); }
	
	
	@Test
	public void testFindFournisseur(){
		Fournisseur p=repo.retrieveFournisseur(1L);
		System.out.println(p);
		System.out.println(p);
	}
	
	@Test
	public void testUpdateFournisseur(){
		Fournisseur p=repo.retrieveFournisseur(1L);
		p.setLibelleFournisseur("fr");
		repo.addFournisseur(p);
		}
	
	@Test
	public void testDeleteFournisseur()

	{
		repo.deleteFournisseur(1L);
	}
	
	@Test 
	public void testListerTousFournisseurs () { 
		List<Fournisseur> prods = repo.retrieveAllFournisseurs(); 
		for (Fournisseur p : prods) { System.out.println(p); 
		}
	}

}

