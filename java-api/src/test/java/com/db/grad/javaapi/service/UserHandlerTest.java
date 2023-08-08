package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class UserHandlerTest {
    @Mock
    private UsersRepository itsUserRepo;
    @InjectMocks
    private UserHandler cut;

    @Test
    public  void    add_a_user_return_number_of_users_in_repo_is_one()
    {
        // arrange
        cut = new UserHandler(itsUserRepo);
        User theUser = new User();
        Mockito.when(itsUserRepo.save(theUser)).thenReturn(theUser);
        Mockito.when(itsUserRepo.count()).thenReturn(1L);
        theUser.setUsername("Bruno");

        cut.addUser(theUser);

        int expectedResult = 1;

        // act
        long actualResult = cut.getNoOfUsers();

        // assert
        assertEquals( expectedResult, actualResult );
    }

}
