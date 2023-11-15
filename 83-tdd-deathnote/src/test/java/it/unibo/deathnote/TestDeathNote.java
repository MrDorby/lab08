package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.Thread;
import org.junit.jupiter.api.Assertions;
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
    }

    @Test
    public void validRules(){
        for(String s: DeathNote.RULES){
            assertNotNull(s);
        }
    }

    @Test
    public void nameWritten(){
        assertFalse(death.isNameWritten("Pippo"));
        death.writeName("Pippo");
        assertTrue(death.isNameWritten("Pippo"));
        assertFalse(death.isNameWritten("Pluppo"));
        assertFalse(death.isNameWritten(""));
    }

    @Test
    public void publicDeathCause(){
        try {
            death.writeDeathCause("");
            fail("Error: expected IllegalStateException");
        } catch (IllegalStateException e) {
            death.writeName("Pippo");
            assertEquals(death.getDeathCause("Pippo"), "heart attack");
            death.writeName("Pluppo");
            death.writeDeathCause("karting accident");
            try{
                Thread.sleep(100);
            }catch(InterruptedException m){
                death.writeDeathCause("RIP");
                assertEquals(death.getDeathCause("Pluppo"), "RIP");
            }
        }
    }

    @Test
    public void publicDeathDetail(){
        try {
            death.writeDetails("");
            fail("Error: expected IllegalStateException");
        } catch (IllegalStateException e) {
            death.writeName("Pippo");
            assertEquals(death.getDeathDetails("Pippo"), "");
            death.writeDetails("ran for too long");
            death.writeName("Pluppo");
            try{
                Thread.sleep(6100);
            }catch(InterruptedException m){
                death.writeDetails("RIP");
                assertEquals(death.getDeathDetails("Pluppo"), "RIP");
            }
        }
    }

}
