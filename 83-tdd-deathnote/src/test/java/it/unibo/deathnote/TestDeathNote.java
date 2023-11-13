package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.deathnote.api.DeathNote;

class TestDeathNote {
    private DeathNote death;
   @BeforeEach
   public void setUp(){
    this.death = new DeathNoteImpl();
   }

   @Test
   public void validRange(){
    try{
        death.getRule(0);
        fail("Error: expected IllegalArgumentException");
    }catch(IllegalArgumentException e){
        assertNotNull(e, e.toString());
        assertEquals(0, e.toString().length());
    }

    try {
        
    } catch (Exception e) {
        // TODO: handle exception
    }
   }
}