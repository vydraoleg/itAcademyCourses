package by.azot.asutp.services.services;

import by.azot.asutp.api.services.IUtilService;
import by.azot.asutp.web.BookDetails;
import by.azot.asutp.web.WebScraper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtilService implements IUtilService {

    @Autowired
    WebScraper webScraper;

    @Override
    public void getBookByIsbn(String isbn) {
        BookDetails details = this.webScraper.getBookDetailsFromWeb(isbn);
        String stop = "stop";
    }
}


