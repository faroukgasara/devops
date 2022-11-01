package tn.esprit.rh.achat;


import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.IFactureService;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {
	@Autowired
	IFactureService factureService;
	@Autowired
	FactureRepository factureRepository;

	@Test
	public void testAddFacture() throws ParseException {

		SimpleDateFormat dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date dateNaissance = dateFormat.parse("31/09/2000");
		Facture s = new Facture(null, 0, 0, dateNaissance, dateNaissance, false, null, null, null);
		Facture savedStock = factureService.addFacture(s);

		factureService.cancelFacture(savedStock.getIdFacture());

	}

	@Test
	public void testCancelFacture() throws ParseException {

		SimpleDateFormat dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date dateNaissance = dateFormat.parse("31/09/2000");
		Facture s = new Facture(null, 0, 0, dateNaissance, dateNaissance, false, null, null, null);
		Facture savedStock = factureService.addFacture(s);

		Facture s1 = factureService.retrieveFacture(savedStock.getIdFacture());
		factureService.cancelFacture(savedStock.getIdFacture());
		assertNotEquals(s1, savedStock);

	}

	@Test
	public void testretriveFacture() throws ParseException {

		SimpleDateFormat dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date dateNaissance = dateFormat.parse("31/09/2000");
		Facture s = new Facture(null, 0, 0, dateNaissance, dateNaissance, false, null, null, null);
		Facture savedStock = factureService.addFacture(s);

		assertNotNull(factureService.retrieveFacture(savedStock.getIdFacture()));

	}
	@Test
	public void testretriveAllFacture() throws ParseException {

		SimpleDateFormat dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Facture> factures = (List<Facture>) factureService.retrieveAllFactures();
		int expected = factures.size();
		Date dateNaissance = dateFormat.parse("31/09/2000");
		Facture s = new Facture(null, expected, expected, dateNaissance, dateNaissance, false, null, null, null);
		Facture savedStock = factureService.addFacture(s);

		assertEquals(expected +1, factureService.retrieveAllFactures().size());
		factureService.cancelFacture(savedStock.getIdFacture());
		

	}
}