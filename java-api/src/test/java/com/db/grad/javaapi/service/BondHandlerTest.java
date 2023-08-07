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

import java.text.ParseException;
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
        theBond.setBondStatus("active");
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
    public void add_bonds_check_maturing_bonds_are_returned() throws ParseException {
        cut = new BondHandler(bondRepo);
        Bond bond1 = new Bond();

        bond1.setMaturityDate("08/11/2021");
        bond1.setIsin("XS1988387210");
        Bond expectedBond = bond1;

        Bond bond2 = new Bond();
        bond2.setIsin("XS1988387210");
        Date matureDate2 = new Date();
        matureDate2.setYear(2021);
        matureDate2.setMonth(7);
        matureDate2.setDate(2);
        bond2.setMaturityDate("02/07/2021");
        ArrayList<Bond> bonds = new ArrayList<>();
        bonds.add(bond1);
        bonds.add(bond2);
        Mockito.when(bondRepo.findAll()).thenReturn(bonds);



        String expectedIsin = "XS1988387210";

        Date currentDate = new Date();
        currentDate.setYear(2021);
        currentDate.setMonth(11);
        currentDate.setDate(7);
        List<Bond> expectedList = new ArrayList<>();
        expectedList.add(expectedBond);
        List<Bond> result = cut.getMaturing("07/11/2021");

        assertEquals(result.get(0).getIsin(), expectedIsin);
    }

    @Test
    public void add_bonds_check_matured_bonds_are_returned() throws ParseException {
        cut = new BondHandler(bondRepo);
        Bond bond1 = new Bond();
        Date matureDate = new Date();
        matureDate.setYear(2021);
        matureDate.setMonth(11);
        matureDate.setDate(4);
        bond1.setMaturityDate("04/11/2021");
        bond1.setIsin("XS1988387210");
        Bond expectedBond = bond1;

        Bond bond2 = new Bond();
        bond2.setIsin("XS1988387210");
        Date matureDate2 = new Date();
        matureDate2.setYear(2021);
        matureDate2.setMonth(7);
        matureDate2.setDate(2);
        bond2.setMaturityDate("02/07/2021");
        ArrayList<Bond> bonds = new ArrayList<>();
        bonds.add(bond1);
        bonds.add(bond2);
        Mockito.when(bondRepo.findAll()).thenReturn(bonds);



        String expectedIsin = "XS1988387210";

        Date currentDate = new Date();
        currentDate.setYear(2021);
        currentDate.setMonth(11);
        currentDate.setDate(7);
        List<Bond> expectedList = new ArrayList<>();
        expectedList.add(expectedBond);
        List<Bond> result = cut.getMatured("07/11/2021");

        assertEquals(result.get(0).getIsin(), expectedIsin);
    }








}
