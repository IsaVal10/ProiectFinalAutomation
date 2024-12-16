package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import pages.AssistanceContactPage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class AssistanceContactFormSerializationDeserizalizationTest {

    @Test
    public void testSerializationAndDeserialization() throws IOException, ClassNotFoundException {

    String temaSelect = "Returnare produs";
    String prenumeNume = "Valeria Somacescu";
    String email = "somacescuisabela@gmail.com";
    long phone = 729232044L;
    int numarComanda = 1;
    String mesaj = "Produs deteriorat";

    AssistanceContactPage assistanceContactPage = new AssistanceContactPage(
                temaSelect,
                prenumeNume,
                email,
                phone,
                numarComanda,
                mesaj
        );

        Path tempFile = Files.createTempFile("contactForm", ".ser");
        tempFile.toFile().deleteOnExit();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile.toFile()))) {
            out.writeObject(assistanceContactPage);
        }

        AssistanceContactPage deserializedContactForm;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(tempFile.toFile()))) {
            deserializedContactForm = (AssistanceContactPage) in.readObject();
        }

        assertNotNull(deserializedContactForm);
        assertEquals(assistanceContactPage.getTema(), deserializedContactForm.getTema());
        assertEquals(assistanceContactPage.getPrenumeNume(), deserializedContactForm.getPrenumeNume());
        assertEquals(assistanceContactPage.getEmail(), deserializedContactForm.getEmail());
        assertEquals(assistanceContactPage.getPhone(), deserializedContactForm.getPhone());
        assertEquals(assistanceContactPage.getnumarComanda(), deserializedContactForm.getnumarComanda());
        assertEquals(assistanceContactPage.getMesaj(), deserializedContactForm.getMesaj());
    }

    @After
    public void tearDown() {
    }
}