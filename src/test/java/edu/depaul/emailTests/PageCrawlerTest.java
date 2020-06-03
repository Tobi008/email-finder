package edu.depaul.emailTests;

import edu.depaul.email.PageCrawler;
import edu.depaul.email.StorageService;
import org.junit.jupiter.api.Test;

import static edu.depaul.email.StorageService.StorageType.*;
import static org.junit.jupiter.api.Assertions.*;

class PageCrawlerTest {

    @Test
    void getEmails() {
        StorageService store = new StorageService();
            store.addLocation(EMAIL, "email.txt");
            store.addLocation(GOODLINKS, "good-links.txt");
            store.addLocation(BADLINKS, "bad-links.txt");
            PageCrawler crawler = new PageCrawler(store, 35);
            crawler.crawl("http://cdm.depaul.edu");
            crawler.report();
        }

}