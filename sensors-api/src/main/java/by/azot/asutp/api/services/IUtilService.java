package by.azot.asutp.api.services;

import by.azot.asutp.web.BookDetails;
import org.springframework.stereotype.Service;

@Service
public interface IUtilService {
    BookDetails getBookByIsbn(String isbn);
}


