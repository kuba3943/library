package service;

import domain.dto.AuthorDTO;
import domain.dto.BookDTO;
import domain.entity.Author;
import domain.entity.Book;

public class AuthorService {

    private AuthorDTO convertToAuthorDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setBirthPlace(author.getBirthPlace());
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());
        return authorDTO;
    }

}
