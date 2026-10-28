package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test 
    void constructor(){
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        int result = store.getTorpedoCount();

        // Assert
        assertEquals(1, result);
        assertEquals(false, store.isEmpty());
    }

    @Test
    void fire_Success(){
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 0.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(0, store.getTorpedoCount());
        assertEquals(true, result);
        assertEquals(true, store.isEmpty());
    }

    
    @Test 
    void fire_Failure(){
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(1, store.getTorpedoCount());
        assertEquals(false, result);
        assertEquals(false, store.isEmpty());
    }
    
    @Test
    void fire_IllegalArgumentException(){
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 0.0);

        // Act & Assert
        try {
            store.fire(2);
        } catch (IllegalArgumentException e) {
            assertEquals("numberOfTorpedos", e.getMessage());
        }
    }

    @Test 
    void fire_IllegalArgumentException_Zero(){
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 0.0);

        // Act & Assert
        try {
            store.fire(0);
        } catch (IllegalArgumentException e) {
            assertEquals("numberOfTorpedos", e.getMessage());
        }
    }
    
}
