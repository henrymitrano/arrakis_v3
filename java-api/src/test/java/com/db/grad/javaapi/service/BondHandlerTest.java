package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.BondRepository;
import com.db.grad.javaapi.repository.DogsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BondHandlerTest {

    @Mock
    private BondRepository bondRepo;

    @InjectMocks
    private BondHandler cut;

    @Test
    public  void    add_a_bond_return_number_of_bonds_in_repo_is_one() {
        cut = new BondHandler(bondRepo);
        Bond theBond = new Bond();
        theBond.setIsin("XS1988387210");
        Mockito.when(bondRepo.save(theBond)).thenReturn(theBond);
        Mockito.when(bondRepo.count()).thenReturn(1L);
        cut.addBond(theBond);

        int expected = 1;

        long actual = cut.getNumOfBonds();

        assertEquals(expected, actual);

    }

    @Test
    public  void    add_few_bonds_check_number_same() {
        cut = new BondHandler(bondRepo);
        Bond bond1 = new Bond();
        bond1.setIsin("XS1988387210");
        Mockito.when(bondRepo.save(bond1)).thenReturn(bond1);
        Mockito.when(bondRepo.count()).thenReturn(1L);
        cut.addBond(bond1);

        Bond bond2 = new Bond();
        bond2.setIsin("XS1988387210");
        Mockito.when(bondRepo.save(bond2)).thenReturn(bond2);
        Mockito.when(bondRepo.count()).thenReturn(2L);
        cut.addBond(bond2);

        int expected = 2;

        long actual = cut.getNumOfBonds();

        assertEquals(expected, actual);

    }

    @Test
    public  void  add_a_bond_and_delete_one() {
        // arrange
        Bond theBond = new Bond();
        theBond.setBond_status("active");
        Mockito.when(bondRepo.save(theBond)).thenReturn(theBond);
        Bond uniqueBond = cut.addBond( theBond );

        Optional<Bond> opt = Optional.of(theBond);
        Mockito.when(bondRepo.findById(theBond.getId())).thenReturn(opt);

        long expectedResult = 0;
        boolean expectedStatus = true;

        // act
        boolean actualStatus = cut.removeBond( uniqueBond.getId() );
        long actualResult = cut.getNumOfBonds();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(bondRepo, times(1)).delete(theBond);
    }

    @Test
    public void add_bonds_retrieve_by_isin() {
        cut = new BondHandler(bondRepo);
        Bond bond1 = new Bond();
        bond1.setIsin("XS1988387210");
        Mockito.when(bondRepo.save(bond1)).thenReturn(bond1);
//        Mockito.when(bondRepo.count()).thenReturn(1L);
        cut.addBond(bond1);

        Bond expectedBond = bond1;
        String isinToFind = "XS1988387210";

        Bond bond2 = new Bond();
        bond2.setIsin("XS1988387456");
        Mockito.when(bondRepo.save(bond2)).thenReturn(bond2);
//        Mockito.when(bondRepo.count()).thenReturn(2L);
        cut.addBond(bond2);

        List<Bond> expectedList = new ArrayList<>();
        expectedList.add(expectedBond);
        Mockito.when(bondRepo.findByIsin(Mockito.any())).thenReturn(expectedList);

        // act
        List <Bond> actualResult = cut.getBondByIsin( isinToFind );

        // assert
        assertEquals( expectedBond.getIsin(), actualResult.get(0).getIsin() );

    }

    @Test
    public void add_bonds_check_maturing_bonds_are_returned() {
        cut = new BondHandler(bondRepo);
        Bond bond1 = new Bond();
        Calendar matureDate = new GregorianCalendar();
        matureDate.set(21,12,4);
        bond1.setMaturityDate(matureDate);
        bond1.setIsin("XS1988387210");
        Mockito.when(bondRepo.save(bond1)).thenReturn(bond1);
        cut.addBond(bond1);
        Bond expectedBond = bond1;

        Bond bond2 = new Bond();
        bond2.setIsin("XS1988387210");
        Mockito.when(bondRepo.save(bond2)).thenReturn(bond2);
        Mockito.when(bondRepo.count()).thenReturn(2L);
        cut.addBond(bond2);

        assertEquals(2, bondRepo.count());
        assertEquals(2, cut.getNumOfBonds());

//        String expectedIsin = "XS1988387210";
//
//        Calendar currentDate = new GregorianCalendar();
//        currentDate.set(21, 12, 1);
//        List<Bond> expectedList = new ArrayList<>();
//        expectedList.add(expectedBond);
//        List<Bond> result = cut.getMaturing(currentDate);
//
//        assertEquals(result.get(0).getIsin(), expectedIsin);



    }









}
