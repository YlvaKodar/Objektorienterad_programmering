package Sprint2.TallPeople;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TallPeopleTest {
    TallPeople tallPeople = new TallPeople();

    @TempDir
    Path tempDir;

    @Test
    void findAndProcessTallPeopleInFile() {
    }

    @Test
    void writeTallPeopleToNewFile() throws IOException {
        //Vi har ett temporärt directory som vi redirect filen till. Kom ihåg @TempDir
        Path outputPath = tempDir.resolve("Tall People.txt");

        //Provar skriva till fil
        Path returnPath = tallPeople.writeTallPeopleToNewFile(outputPath, "Slender man", "Creepy Pasta, Reddit\n", 1000, 30, 250);

        //Kolla att returpathet är korrekt
        assertEquals(outputPath, returnPath);

        //Kolla att filen finns
        assertTrue(Files.exists(outputPath));

        //Läs filen
        List<String> lines = Files.readAllLines(outputPath);

        //Kolla att det är rätt antal rader
        assertEquals(2, lines.size());

        //Kolla att det är rätt innehåll
        assertEquals("Slender man, Creepy Pasta, Reddit", lines.get(0));

        //Provar lägga till
        tallPeople.writeTallPeopleToNewFile(outputPath, "Shirt Girl", "Haters gonna Hate\n", 25, 55, 150);

        //Läs filen
        lines = Files.readAllLines(outputPath);
        assertEquals(4, lines.size());
    }

    //Onödig. Ta bort.
    @Test
    void testExceptionHandling() {
        Path outputPath = tempDir.resolve("Tall People.txt");
        Path returnedPath = tallPeople.writeTallPeopleToNewFile(outputPath, "Slender man", "Creepy Pasta, Reddit", 1000, 30, 250);

        assertNull(returnedPath);
    }

    @Test
    void addToTallList() {
    }

    @Test
    void getTallPeeps() {
    }
}