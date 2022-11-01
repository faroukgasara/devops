package tn.esprit.rh.achat;


import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FactureServiceMock {
	
	
	@InjectMocks
	FactureServiceImpl factureService;
	
	@Mock
	FactureRepository factureRepository;
	
	@Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
	
	Facture f = new Facture(null, 0, 0, new Date(),new Date(),false,null,null,null);
	
	ArrayList<Facture> factures = new ArrayList<Facture>(){
		

			/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

			{
				add(new Facture(null, size(), size(), new Date(),new Date(),false,null,null,null));
				add(new Facture(null, size(), size(), new Date(),new Date(),true,null,null,null));
			}
	};		
	@Test
	
	public void retrieveAllFacturesMock() {
		Mockito.when(factureRepository.findAll()).thenReturn(factures);
		
		//Facture f1 = factureService.retrieveFacture(f.getIdFacture());
		List<Facture> fac = factureService.retrieveAllFactures();
		assertNotNull(fac);
	}
	
	

}