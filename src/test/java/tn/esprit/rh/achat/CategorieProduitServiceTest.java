package tn.esprit.rh.services;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CategorieProduitServiceTest {

    @Mock
    CategorieProduitRepository categorieRepository;

    @InjectMocks
    CategorieProduitServiceImpl categorieService;
    
     CategorieProduit cp1 = new CategorieProduit("2365","produit1");
    CategorieProduit cp2 = new CategorieProduit("5681","produit5");


    @Test
	public void addCategrieTest() {
    	when(categorieRepository.save(cp1)).thenReturn(cp1);
    	assertNotNull(cp1);
		assertEquals(cp1, categorieService.addCategorieProduit(cp1)); 
		System.out.println("add works !");
	}
	
	@Test
    public void DeleteCategrieTest() {
    	categorieRepository.save(cp1);
    	categorieService.deleteCategorieProduit(cp1.getIdCategorieProduit());
    	verify(categorieRepository, times(1)).deleteById(cp1.getIdCategorieProduit());
    	System.out.println("Delete works !");
    	
    }

    
    @Test 
    public void UpdateCategrieTest() {
    	when(categorieRepository.save(cp1)).thenReturn(cp1);
    	assertNotNull(cp1);
    	assertEquals(cp1, categorieService.updateCategorieProduit(cp1));
    	System.out.println("Update works !");
    }
    
    @Test
    public void retrieveCategrieTest() {
    	when(categorieRepository.findById(cp1.getIdCategorieProduit())).thenReturn(Optional.of(cp1));
    	assertEquals(cp1, categorieService.retrieveCategorieProduit(cp1.getIdCategorieProduit()));
    	System.out.println("Retrieve works !");
    }
    
    
}


}
