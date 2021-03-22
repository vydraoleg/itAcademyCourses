package by.azot.asutp.api.services;

import org.springframework.stereotype.Service;

@Service
public interface IUtilService {
    void getBookByIsbn(String isbn);
}


