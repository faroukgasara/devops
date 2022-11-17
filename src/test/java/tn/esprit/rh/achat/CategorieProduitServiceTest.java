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

    /*@Test
    public void testRetrieveCategorieProduit() {

        CategorieProduit categorie = new CategorieProduit(null,"xyz","xyz");
        categorie.setidCategorieProduit(1L);

        Mockito.when(categorieRepository.findById(1L)).thenReturn(Optional.of(categorie));
        categorieService.retrieveCategorieProduit(1L);
        Assertions.assertNotNull(categorie);

        System.out.println(categorie);
        System.out.println(" Retrieve is working correctly...!!");

    }

    @Test
    public void createCategorieProduitTest()
    {

        CategorieProduit categorie2 = new CategorieProduit(null,"abcd", "abcd");
        categorie2.setidCategorieProduit(2L);

        categorieService.addCategorieProduit(categorie2);
        verify(categorieRepository, times(1)).save(categorie2);
        System.out.println(categorie2);
        System.out.println(" Create is working correctly...!!");
    }

    @Test
    public void getAllCategorieProduitTest()
    {
        @SuppressWarnings("serial")
        List<CategorieProduit> Catprodlist = new ArrayList<CategorieProduit>() {

            {
                add(new CategorieProduit(null,"qwerty","qwerty"));
                add(new CategorieProduit(null,"aqw","aqw"));
                add(new CategorieProduit(null,"azerty","azerty"));
            }};


        when(categorieService.retrieveAllCategorieProduits()).thenReturn(Catprodlist);
        //test
        List<CategorieProduit> catList = categorieService.retrieveAllCategorieProduits();
        assertEquals(3,catList.size());
        System.out.println(" Retrieve all is working correctly...!!");

    }*/

   /* @Test
    public void TestDeleteCategorieProduit(){

        CategorieProduit categorie1 = new CategorieProduit(null,"az","az");
        categorie1.setidCategorieProduit(1L);

        Mockito.lenient().when(categorieRepository.findById(categorie1.getIdCategorieProduit())).thenReturn(Optional.of(categorie1));

        categorieService.deleteCategorieProduit(1L);
        verify(categorieRepository).deleteById(categorie1.getIdCategorieProduit());

        System.out.println(categorie1);
        System.out.println(" Delete is working correctly...!!");
    }*/
    //done

}
