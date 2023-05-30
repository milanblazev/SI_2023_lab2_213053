package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private final User user1=new User("milan", "password", "milan@gmail.com");
    private final User user2=new User("username", "password", "email2@gmail.com");
    private final List<User> allusers = new ArrayList<>();

    @Test
    void everybranch() {
        RuntimeException exception;
        allusers.add(user1);
        allusers.add(user2);
        exception = assertThrows(RuntimeException.class, ()->SILab2.function(null,allusers));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        assertEquals(false, SILab2.function(new User(null, "pasw", "sd@gmail.com"), allusers));
        assertEquals(false, SILab2.function(new User("milan", "pas w11 v2", "milan@gmail.com"), allusers));
        assertEquals(false, SILab2.function(new User("milan", "pasw11v21", "milangmailcom"), allusers));

        assertEquals(false, SILab2.function(new User("milan", "pas@w11!v2", "milan@gmail.com"), allusers));

    }

    @Test
    void multipleconditions() {
RuntimeException exception;
allusers.add(user1);
allusers.add(user2);
        exception = assertThrows(RuntimeException.class, ()->SILab2.function(null, allusers ));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        exception = assertThrows(RuntimeException.class, ()->SILab2.function(new User("milan", null, "XXX"), allusers ));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        exception = assertThrows(RuntimeException.class, ()->SILab2.function(new User("milan", "milance123", null), allusers ));
        assertTrue(exception.getMessage().contains("Mandatory information missing!"));

        assertEquals(false, SILab2.function(new User("milan", "milance123", "milangmail"), allusers ));

    }

}