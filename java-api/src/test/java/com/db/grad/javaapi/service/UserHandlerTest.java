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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @Test
    public void add_few_users_delete_one_check_number_is_one () {
        // arrange
        User user1 = new User();
        user1.setUsername("Bruno");
        Mockito.when(itsUserRepo.save(user1)).thenReturn(user1);
        User uniqueUser = cut.addUser( user1 );

        Optional<User> opt = Optional.of(user1);
        Mockito.when(itsUserRepo.findById(user1.getId())).thenReturn(opt);

        long expectedResult = 0;
        boolean expectedStatus = true;

        // act
        boolean actualStatus = cut.removeUser( uniqueUser.getId() );
        long actualResult = cut.getNoOfUsers();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsUserRepo, times(1)).delete(user1);
    }



}
