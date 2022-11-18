package com.esprit.examen.services;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.dto.ReglementDto;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ReglementServiceTest {


    @Mock
    ReglementRepository sr;
    @InjectMocks
    StockServiceImpl ss;

    @Mock
    ReglementRepository produitRepository;

   @InjectMocks
   ReglementServiceImpl reglementService = mock(ReglementServiceImpl.class);
   ReglementDto reglement = ReglementDto
           .builder()
           .dateReglement(new Date())
           .idReglement(1L)
           .payee(false)
           .montantRestant(120F)
           .montantPaye(100F)
           .build();

   ReglementDto reglement2 = ReglementDto
           .builder()
           .dateReglement(new Date())
           .idReglement(2L)
           .payee(true)
           .montantRestant(100F)
           .montantPaye(100F)
           .build();


   ReglementDto reglement3 = ReglementDto
           .builder()
           .dateReglement(new Date())
           .idReglement(3L)
           .payee(false)
           .montantRestant(250F)
           .montantPaye(200F)
           .build();


   List<ReglementDto> list = new ArrayList<ReglementDto>() {
       {
           add(reglement2);
           add(reglement3);
       }
   };

    




   @Test
   public void testAddReglement() {

       when(reglementService.addReglement(reglement)).thenReturn(reglement);

       Assert.assertNotNull(reglementService.addReglement(reglement).getIdReglement());

       verify(reglementService).addReglement(reglement);

   }


  /* @Test
   public void testRetreiveAllReglements() {

       when(reglementService.retrieveAllReglements()).thenReturn(list);
       assertNotEquals(list.size(), 0);

   }*/
   @Test
   public void testretRieveReglement() {

       when(reglementService.retrieveReglement(reglement.getIdReglement())).thenReturn(reglement);
       assertEquals(reglement, reglementService.retrieveReglement(reglement.getIdReglement()));
       verify(reglementService).retrieveReglement(reglement.getIdReglement());
   }


   @Test
   public void testUpdateReglement(){

       when(reglementService.updateReglement(reglement)).thenReturn(reglement);
       assertNotEquals(Optional.ofNullable(reglement.getMontantPaye()),Optional.of(reglementService.updateReglement(reglement)));
       verify(reglementService).updateReglement(reglement);


   }
}



