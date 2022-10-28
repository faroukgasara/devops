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
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProduitServiceImplTest {
	
	@Autowired
	private ProduitRepository repo;
	
	
	@Test
	public void testCreateProduit() {
	Produit prod = new Produit( "100" ,"200");
	repo .save( prod ); }
	
	
	@Test
	public void testFindProduit(){
		Produit p=repo.findById(1L).get();System.out.println(p);
		System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit(){
		Produit p=repo.findById(1L).get();
		p.setLibelleProduit("fr");
		repo.save(p);
		}
	
	@Test
	public void testDeleteProduit()

	{
		repo.deleteById(1L);
	}
	
	@Test 
	public void testListerTousProduits () { 
		List<Produit> prods = repo.findAll(); 
		for (Produit p : prods) { System.out.println(p); 
		}
	}

}

