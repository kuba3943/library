package service;

import domain.dto.AuthorDTO;
import domain.dto.BorrowDTO;
import domain.entity.Author;
import domain.entity.Borrow;

public class BorrowService {

    private BorrowDTO convertToBorrowDTO(Borrow borrow) {
        BorrowDTO borrowDTO = new BorrowDTO();
        borrowDTO.setBookTitle(borrow.getBookId().getTitle());
        borrowDTO.setBorrowerLastName(borrow.getBorrowerId().getLastName());
        borrowDTO.setRentalDate(borrow.getRentalDate());
        return borrowDTO;
    }
}
