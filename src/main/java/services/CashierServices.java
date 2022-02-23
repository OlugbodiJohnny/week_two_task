package services;

import models.Staff;
import models.Store;

import java.io.File;
import java.io.IOException;

public interface CashierServices extends CommonClassImpl {
    void fetchProductFromStore(Staff staff, Store store, String filename) throws IOException;
    void printReceipt(Integer customerId, Store store);
}
