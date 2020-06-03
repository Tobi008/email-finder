package edu.depaul.emailTests;

import edu.depaul.email.EmailFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailFinderTest {
    @Test
    @DisplayName("Should run the provided URL")
    void testRun() {
        String[] url = {"https://cdm.depaul.edu"};
        EmailFinder.main(url);
    }
    @Test
    @DisplayName("Testing EmailFinder class with no URL")
    void NoURLTest(){
        EmailFinder testURL = new EmailFinder();
        String[] Args = {""};
        testURL.run(Args);

        String path = "badLinks.txt";
        Stream<String> txtLines = null;
        try {
            txtLines = Files.lines(Paths.get(path));
            String res = txtLines.collect(Collectors.joining(System.lineSeparator()));
            assertEquals(res, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Testing EmailFinder class with Valid URL")
    void URLTest(){
        EmailFinder testURL = new EmailFinder();
        String[] Args = {"ValidURL.txt"};
        testURL.run(Args);

        String path = "good-Links.txt";
        Stream<String> txtLines = null;
        try {
            txtLines = Files.lines(Paths.get(path));
            String res = txtLines.collect(Collectors.joining(System.lineSeparator()));
            assertEquals(res, "ValidURL.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    @Test
    @DisplayName("Testing EmailFinder output with valid argument")
    void OutputTest(){
        EmailFinder testURL = new EmailFinder();
        String[] Args = {"http://cdm.depaul.edu", "10"};
        testURL.run(Args);
    }
}
