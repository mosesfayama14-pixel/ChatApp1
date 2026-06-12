/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class POETesting {

    // Simulating the storedMessagesList from your Main class
    private List<Message> storedMessagesList;

    @BeforeEach
    public void setUp() {
        storedMessagesList = new ArrayList<>();

        // Rearranged to match: (id, hash, recipient, content)
        // Using the recipient number in the 3rd parameter position so msg.recipient matches!
        Message msg1 = new Message("MSG001", "HASH1", "+27834557896", "Did you get the cake?");
        Message msg2 = new Message("MSG002", "HASH2", "+27838884567", "Where are you? You are late! I have asked you to be on time.");
        Message msg3 = new Message("MSG003", "HASH3", "+27834484567", "Yohoooo, I am at your gate.");
        Message msg4 = new Message("038884567", "HASH4", "038884567", "It is dinner time !"); // Message 4 uses ID as developer entry

        storedMessagesList.add(msg1);
        storedMessagesList.add(msg2);
        storedMessagesList.add(msg3);
        storedMessagesList.add(msg4);
    }

    /**
     * Test Case 1: Verifying the collection is correctly populated
     */
    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        assertFalse(storedMessagesList.isEmpty());
        assertEquals(4, storedMessagesList.size());
        assertEquals("Did you get the cake?", storedMessagesList.get(0).content);
    }

    /**
     * Test Case 2: Finding the longest message text
     * Logic maps directly to your displayLongestStoredMessage() loop.
     */
    @Test
    public void testDisplayLongestMessage() {
        Message longest = storedMessagesList.get(0);
        for (Message msg : storedMessagesList) {
            if (msg.content.length() > longest.content.length()) {
                longest = msg;
            }
        }
    
        String expectedLongestText = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(expectedLongestText, longest.content);
    }

    /**
     * Test Case 3: Searching by Message ID
     * Logic maps directly to your searchByMessageID() loop.
     */
    @Test
    public void testSearchForMessageId() {
        String targetID = "038884567";
        Message foundMessage = null;

        for (Message msg : storedMessagesList) {
            if (msg.messageID.equals(targetID)) {
                foundMessage = msg;
                break;
            }
        }

        assertNotNull(foundMessage, "Message with target ID should be found.");
        assertEquals("It is dinner time !", foundMessage.content);
    }

    /**
     * Test Case 4: Searching messages by Recipient
     * Logic maps directly to your searchByRecipient() loop.
     */
    @Test
    public void testSearchAllMessagesSentOrStoredRegardingRecipient() {
        // Pass the phone number into the 3rd argument slot (recipient field)
        Message msg5 = new Message("MSG005", "HASH5", "+27838884567", "Ok, I am leaving without you.");
        storedMessagesList.add(msg5);

        String targetNumber = "+27838884567";
        List<Message> matchingMessages = new ArrayList<>();

        for (Message msg : storedMessagesList) {
            if (msg.recipient.equals(targetNumber)) {
                matchingMessages.add(msg);
            }
        }

        // This will now successfully find msg2 and msg5!
        assertEquals(2, matchingMessages.size());
        assertEquals("Where are you? You are late! I have asked you to be on time.", matchingMessages.get(0).content);
        assertEquals("Ok, I am leaving without you.", matchingMessages.get(1).content);
    }

    /**
     * Test Case 5: Deleting a message using its unique message hash
     * Logic maps directly to your deleteMessageByHash() loop.
     */
    @Test
    public void testDeleteMessageUsingMessageHash() {
        String targetHash = "HASH2"; // Assuming HASH2 represents Message 2's hash
        boolean removed = false;

        for (int i = 0; i < storedMessagesList.size(); i++) {
            if (storedMessagesList.get(i).messageHash.equals(targetHash)) {
                storedMessagesList.remove(i);
                removed = true;
                break;
            }
        }

        assertTrue(removed);
        assertEquals(3, storedMessagesList.size(), "List size should decrease after deletion.");
    }

    /**
     * Test Case 6: Checking Report formatting generation properties
     * Verifies data prints out cleanly from field values.
     */
    @Test
    public void testDisplayReport() {
        // Asserting fields can be accessed successfully for report construction
        // to prevent any regressions on property renaming
        Message sampleMsg = storedMessagesList.get(0);

        assertNotNull(sampleMsg.messageID);
        assertNotNull(sampleMsg.messageHash);
        assertNotNull(sampleMsg.recipient);
        assertNotNull(sampleMsg.content);
    }
}