package edu.depaul.emailTests;

import edu.depaul.email.PageParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PageParserTest {

    @Test
    @DisplayName("should create a document from a string")
    void TestDoc() {
        String HTML = "<html><body>hello world</body></html>";
        Document doc = Jsoup.parse(HTML);
        assertEquals("hello world", doc.body().text());
    }

    @Test
    @DisplayName("can find link in <a> tag")
    void findLink() {
        String html = "<html><a href='https://cdm.depaul.edu'></a></body></html>";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        Set<String> link = parser.findLinks(doc);
        assertEquals("https://cdm.depaul.edu", link.toArray()[0]);
    }
    @Test
    @DisplayName("can find multiple links in <a> tags")
    void findMultipleLinks() {
        String html = "<html><a href='https://cdm.depaul.edu'></a>" +
                "<a href='https://google.com'></a>" +
                "<a href='https://reddit.com'></a></body></html>";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        Set<String> links = parser.findLinks(doc);
        assertEquals("https://cdm.depaul.edu", links.toArray()[0]);
        assertEquals("https://google.com", links.toArray()[1]);
        assertEquals("https://reddit.com", links.toArray()[2]);
    }
    @Test
    @DisplayName("can find the links in <a> tag with Base tag included")
    void findLink_withBaseLink() {
        String html = "<html><head><base href='https://cdm.depaul.edu' target='_blank'></head><body> <a href='Bachelors-Programs.aspx'>HTML base tag</a></body></html>";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        Set<String> links = parser.findLinks(doc);
       assertEquals("Bachelors-Programs.aspx", links.toArray()[0]);

    }
}