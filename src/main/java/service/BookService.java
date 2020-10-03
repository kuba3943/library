package service;

import domain.dto.AuthorDTO;
import domain.dto.BookDTO;
import domain.entity.Author;
import domain.entity.Book;

public class BookService {

    public BookDTO convertToBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBorrow(book.getBorrow());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setAuthorFirstName(book.getAuthorId().getFirstName());
        bookDTO.setAuthorLastName(book.getAuthorId().getLastName());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setPages(book.getPages());
        bookDTO.setReleaseDate(book.getReleaseDate());
        bookDTO.setSummary(book.getSummary());
        return bookDTO;
    }
}
