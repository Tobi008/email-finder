package edu.depaul.emailTests;

import edu.depaul.email.ListWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class ListWriterTests {
    @Test
    @DisplayName("Testing list creation")
    void TestListCreation() {
        String[] Arr = new String[]{"zero", "one", "two", "three", "four"};
        String TestString = Arr[0] + "\n" + Arr[1] + "\n" + Arr[2] + "\n" + Arr[3] + "\n" + Arr[4] + "\n";
        ArrayList<String> List = new ArrayList<String>();

        for (int i = 0; i < Arr.length; i++) {
            List.add(Arr[i]);
        }

        OutputStream output = new ByteArrayOutputStream();
        ListWriter Writer = new ListWriter(output);

        try {
            Writer.writeList(List);
            assertEquals(TestString, output.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @DisplayName("Testing list creation with Mock")
    void MockTestWriter() {
        OutputStream testStream = mock(OutputStream.class);
        ListWriter writer = mock(ListWriter.class);
        String[] Arr = new String[]{"zero", "one", "two", "three", "four"};
        Collection<String> collection = new ArrayList<String>();
        for (int i = 0; i < Arr.length; i++) {
            collection.add(Arr[i]);
        }
        try {
            doNothing().when(writer).writeList(Collections.singleton(collection.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    @DisplayName("should write Args to the output")
    void SimpleListCreation() throws IOException {
        String[] Args = {"x", "y", "z"};

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ListWriter writer = new ListWriter(output);
        writer.writeList(Arrays.asList(Args));
        assertEquals("x\ny\nz\n", output.toString());
    }
    }

