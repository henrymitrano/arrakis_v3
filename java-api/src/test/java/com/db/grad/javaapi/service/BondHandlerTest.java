package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.BondRepository;
import com.db.grad.javaapi.repository.DogsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class BondHandlerTest {

    @Mock
    private BondRepository bondRepo;

    @InjectMocks
    private BondHandler cut;

    @Test
    public  void    add_a_bond_return_number_of_bonds_in_repo_is_one() {


    }


}
