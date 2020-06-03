package edu.depaul.emailTests;

import edu.depaul.email.EmailFinderException;
import edu.depaul.email.PageFetcher;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
class PageFetcherTest {

    @Test
    @DisplayName("Using Mock to test getString method using a static String")
    void MockGetString() {
        PageFetcher newPage = mock(PageFetcher.class);
        String URL = "http://cdm.depaul.edu";
        when(newPage.getString(URL)).thenCallRealMethod();
        newPage.getString(URL);
        verify(newPage,times(1)).getString(URL);

    }

    @Test
    @DisplayName("getString should throw an exception if not able to connect to the URL provided")
    void getString_EmptyURL() {
        PageFetcher newPage = mock(PageFetcher.class);
        Document doc = mock(Document.class);
        String URL = "";
        when(newPage.getString(anyString())).thenThrow(EmailFinderException.class);

    }
    @Test
    @DisplayName("Using Mock to test get function")
    void Testget() {
        PageFetcher newPage = mock(PageFetcher.class);
        Document doc = mock(Document.class);
        when(newPage.get(anyString())).thenReturn(doc);

    }
    @Test
    @DisplayName("Mocking get with static string")
    void MockTestGet() {
        PageFetcher newPage = mock(PageFetcher.class);
        String URL = "http://cdm.depaul.edu";
        when(newPage.get(URL)).thenCallRealMethod();
        newPage.get(URL);
        verify(newPage,times(1)).get(URL);

    }
}