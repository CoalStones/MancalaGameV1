/***************
 * This test serves the sole purpose of verifying the existence of methods in the class.
 * It does not validate the types of expected return values, 
 * but it does confirm the presence of a return type if expected.
 * Please note that this form of testing is not suitable for comprehensive unit testing.
 * It has been designed solely as a tool to identify missing methods within your implementation.
 */

package mancala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BoardTest {

    private Board board;

    @Test
    void testBoardMethodsExist() {
        Method[] methods = Board.class.getDeclaredMethods();

        // Assertions for void methods
        assertAll(
            () -> assertTrue(hasVoidMethod(methods, "resetBoard"), "resetBoard method is missing"),
            () -> assertTrue(hasVoidMethod(methods, "initializeBoard"), "initializeBoard method is missing"),
            () -> assertTrue(hasVoidMethod(methods, "setUpPits"), "setUpPits method is missing"),
            () -> assertTrue(hasVoidMethod(methods, "setUpStores"), "setUpStores method is missing"),
            () -> assertTrue(hasVoidMethod(methods, "registerPlayers", Player.class, Player.class),
                                   "registerPlayers method is missing")
        );

        // Assertions for methods with non-void return types
        assertAll(
            () -> assertTrue(hasMethod(methods, "moveStones", int.class, Player.class), "moveStones method is missing"),
            () -> assertTrue(hasMethod(methods, "distributeStones", int.class), "distributeStones method is missing"),
            () -> assertTrue(hasMethod(methods, "captureStones", int.class), "captureStones method is missing"),
            () -> assertTrue(hasMethod(methods, "getPits"), "getPits method is missing"),
            () -> assertTrue(hasMethod(methods, "getStores"), "getStores method is missing"),
            () -> assertTrue(hasMethod(methods, "isSideEmpty",int.class), "isSideEmpty method is missing"),            
            () -> assertTrue(hasMethod(methods, "getNumStones", int.class), "getNumStones method is missing"),
            () -> assertTrue(hasMethod(methods, "toString"), "toString method is missing")
        );
    }

    private boolean hasVoidMethod(Method[] methods, String methodName, Class<?>... parameterTypes) {
        for (Method method : methods) {
            if (method.getName().equals(methodName) && method.getReturnType() == void.class 
                && parameterTypesMatch(method.getParameterTypes(), parameterTypes)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasMethod(Method[] methods, String methodName, Class<?>... parameterTypes) {
        for (Method method : methods) {
            if (method.getName().equals(methodName) && method.getReturnType() != void.class 
                && parameterTypesMatch(method.getParameterTypes(), parameterTypes)) {
                return true;
            }
        }
        return false;
    }

    private boolean parameterTypesMatch(Class<?>[] parameterTypes, Class<?>... expectedTypes) {
        if (parameterTypes.length != expectedTypes.length) {
            return false;
        }
        for (int i = 0; i < parameterTypes.length; i++) {
            if (!parameterTypes[i].equals(expectedTypes[i])) {
                return false;
            }
        }
        return true;
    }

    @BeforeEach
    void newBoard(){
        board = new Board();
    }

    @Test
    void throwsExceptionDistributionHigh(){
        assertThrows(PitNotFoundException.class, () -> board.distributeStones(13));
    }

    @Test
    void throwsExceptionDistributionLow(){
        assertThrows(PitNotFoundException.class, () -> board.distributeStones(-1));
    }

    @Test
    void playerOnePlaceLow(){
        try{
            assertEquals(4,board.distributeStones(0));
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerOnePlace");
        }
    }

    @Test
    void playerOnePlaceMed(){
        try{
            assertEquals(4,board.distributeStones(3));
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerOnePlace");
        }
    }

    @Test
    void playerOnePlaceHigh(){
        try{
            assertEquals(4,board.distributeStones(5));
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerOnePlace");
        }
    }

    @Test 
    void playerTwoPlaceLow(){
        try{
            assertEquals(4,board.distributeStones(6));
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerTwoPlace");
        }
    }

    @Test 
    void playerTwoPlaceMed(){
        try{
            assertEquals(4,board.distributeStones(8));
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerTwoPlace");
        }
    }

    @Test 
    void playerTwoPlaceHigh(){
        try{
            assertEquals(4,board.distributeStones(11));
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerTwoPlace");
        }
    }

    @Test
    void captureAfterPlayerTwoStore(){
        try{
            assertEquals(8,board.captureStones(0));
            board.toString();
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerTwoPlace");
        }
    }

    @Test
    void captureBeforePlayerOneStore(){
        try{
            assertEquals(8,board.captureStones(5));
            board.toString();
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerTwoPlace");
        }
    }

    @Test
    void captureAfterPlayerOneStore(){
        try{
            assertEquals(8,board.captureStones(6));
            board.toString();
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerTwoPlace");
        }
    }

    @Test
    void captureBeforePlayerTwoStore(){
        try{
            assertEquals(8,board.captureStones(11));
            board.toString();
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerTwoPlace");
        }
    }

    @Test
    void captureAMiddlePit(){
        try{
            assertEquals(8,board.captureStones(3));
            board.toString();
        }catch (PitNotFoundException err){
            System.out.println("Pit not found PlayerTwoPlace");
        }
    }

    @Test
    void getNumStonesExceptionHigh(){
        assertThrows(PitNotFoundException.class, () -> board.getNumStones(13));
    }

    @Test
    void getNumStonesExceptionLow(){
        assertThrows(PitNotFoundException.class, () -> board.getNumStones(-1));
    }

    @Test
    void getNumStones(){
        try{
            assertEquals(4,board.getNumStones(5));
        } catch(PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void getNumStonesExceptionAfterDistribution(){
        try{
            board.distributeStones(11);
            assertEquals(5,board.getNumStones(0));
        } catch(PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void isSideExceptionThrown(){
        assertThrows(PitNotFoundException.class, () -> board.isSideEmpty(13));
    }

    @Test
    void isPlayerOneSideEmptyLow(){
        try{
            assertEquals(false,board.isSideEmpty(0));
        } catch(PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void isPlayerOneSideEmptyMid(){
        try{
            assertEquals(false,board.isSideEmpty(4));
        } catch(PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void isPlayerOneSideEmptyHigh(){
        try{
            assertEquals(false,board.isSideEmpty(5));
        } catch(PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void isPlayerTwoSideEmptyLow(){
        try{
            assertEquals(false,board.isSideEmpty(6));
        } catch(PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void isPlayerTwoSideEmptyMed(){
        try{
            assertEquals(false,board.isSideEmpty(8));
        } catch(PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void isPlayerTwoSideEmptyHigh(){
        try{
            assertEquals(false,board.isSideEmpty(11));
        } catch(PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void playerOneSideIsEmpty(){
        board.tallySide();
        try{
            assertEquals(true,board.isSideEmpty(4));
        } catch (PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void playerTwoSideIsEmpty(){
        board.tallySide();
        try{
            assertEquals(true,board.isSideEmpty(8));
        } catch (PitNotFoundException err){
            System.out.println(err.getMessage());
        }
    }

    @Test
    void resetBoard(){
        

        try{
            board.tallySide();
            assertEquals(true,board.isSideEmpty(4));
            assertEquals(true,board.isSideEmpty(8));

            board.resetBoard();

            assertEquals(false,board.isSideEmpty(4));
            assertEquals(false,board.isSideEmpty(8));
        } catch(PitNotFoundException err){
            System.out.println(err.getMessage());
        }
        
    }

    @Test
    void registerPlayers(){
        Player one = new Player();
        Player two = new Player();

        board.registerPlayers(one, two);

        assertEquals(0, one.getStoreCount());
        assertEquals(0, two.getStoreCount());

        two.getStore().addStones();

        assertEquals(0, one.getStoreCount());
        assertEquals(1, two.getStoreCount());
    }
    
}
