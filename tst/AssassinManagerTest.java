import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for the AssassinManager class
 */

//Test constructor
public class AssassinManagerTest {

    /**
     * Test case 1 provided as an example
     * Test graveyardContains should not have the person who wasn't killed
     */
    @Test
    public void graveyardContainsNegativeTest(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        manager.kill("Grayson");
        Assert.assertFalse(manager.graveyardContains("ocean"));
    }

    /**
     * Test case 2 provided as an example
     * Test constructor with invalid argument
     * Should throw IllegalArgumentException
     */
    @Test
    public void constructorNegativeTest(){
        try{
            List<String> emptyList = new ArrayList<String>();
            AssassinManager manager = new AssassinManager(emptyList);
            Assert.fail("AssassinManager should throw IllegalArgumentExeption for empty list");
        }catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test the printKillRing method
     * Checks to see if the method correctly prints the killRing
     */
    @Test
    public void printKillRingTest(){
        List<String> list1 = new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Nathan");
        AssassinManager manager = new AssassinManager(list1);
        manager.printKillRing();
    }
    /**
     * Test the printGraveyard method
     * Checks to see if the method correctly prints the graveyard
     */
    @Test
    public void printGraveyardTest(){
        List<String> list1 = new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Nathan");
        AssassinManager manager = new AssassinManager(list1);
        manager.kill("Nathan");
        manager.printGraveyard();
    }

    /**
     * Test the isGameOver method
     * Should be false
     */
    @Test
    public void isGameOverTest(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        Assert.assertFalse(manager.isGameOver());
    }

    /**
     * Test the killRingContains method
     * Should be false
     */
    @Test
    public void killRingContainsTest(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        Assert.assertFalse(manager.killRingContains("Nathan"));
    }

    /**
     * Test the killRingContains method
     * Should be false
     */
    @Test
    public void killRingContainsTest2(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        Assert.assertTrue(manager.killRingContains("Chris"));
    }

    /**
     * Test the graveyardContains method
     * Should be false
     */
    @Test
    public void graveyardContainsTest(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        Assert.assertFalse(manager.graveyardContains("Chris"));
    }

    /**
     * Test the graveyardContains method
     * Should be true
     */
    @Test
    public void graveyardContainsTest2(){
        List<String> list1 = new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        manager.kill("Chris");
        Assert.assertTrue(manager.graveyardContains("Chris"));
    }

    /**
     * Test the winner method
     * Should be true
     */
    @Test
    public void winnerTest(){
        List<String> list1 = new ArrayList<String>();
        list1.add("Grayson");
        AssassinManager manager = new AssassinManager(list1);
        Assert.assertEquals("Grayson", manager.winner());
    }

    /**
     * Test the kill method
     * Catches the illegal state if the game is over
     */
    @Test
    public void killTest1(){
        try {
            List<String> list1 = new ArrayList<String>();
            list1.add("Grayson");
            AssassinManager manager = new AssassinManager(list1);
            manager.kill("Grayson");
            Assert.fail("The game is over.");
        } catch (IllegalStateException e) {
        }
    }

    /**
     * Test the kill method
     * Catches the illegal argument if the name is not in the list
     */
    @Test
    public void killTest2(){
        try {
            List<String> list1 = new ArrayList<String>();
            list1.add("Grayson");
            list1.add("Michael");
            AssassinManager manager = new AssassinManager(list1);
            manager.kill("Nathan");
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
    }
}