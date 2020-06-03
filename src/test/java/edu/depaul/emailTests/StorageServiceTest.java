package edu.depaul.emailTests;

import edu.depaul.email.EmailFinderException;
import edu.depaul.email.StorageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

class StorageServiceTest {

    @Test
    @DisplayName("Passing a null collection into storeList")
    void storeList_NullCollection(){
        StorageService store = mock(StorageService.class);
        Collection<String> collect = new ArrayList<String>();
        store.addLocation(StorageService.StorageType.BADLINKS,null);
        store.storeList(StorageService.StorageType.BADLINKS,null);
        doThrow(EmailFinderException.class).when(store).storeList(isA(StorageService.StorageType.class),isNull());

    }

    @Test
    @DisplayName("Passing null arguments into storeList")
    void storeList_NullArgs(){
        StorageService store = mock(StorageService.class);
        Collection<String> collect = new ArrayList<String>();
        store.addLocation(null,null);
        store.storeList(null,null);
        doThrow(EmailFinderException.class).when(store).storeList(isNull(),isNull());

    }

    @Test
    @DisplayName("Verifying storeList attempts to write to the location provided by addLocation")
    void storeList() {
        StorageService store = mock(StorageService.class);
        Collection<String> collect = new ArrayList<String>();
        collect.add("ValidURL.txt");
        store.addLocation(StorageService.StorageType.GOODLINKS,"ValidURL.txt");
          doNothing().when(store).storeList(isA(StorageService.StorageType.class),isA(Collection.class));
          store.storeList(StorageService.StorageType.GOODLINKS,collect);
          verify(store,times(1)).storeList(StorageService.StorageType.GOODLINKS,collect);


    }
}