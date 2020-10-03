package service;

import domain.dto.AuthorDTO;
import domain.dto.BorrowerDTO;
import domain.entity.Author;
import domain.entity.Borrower;
import domain.entity.BorrowerDetails;

public class BorrowerService {

    private BorrowerDTO convertToBorrowerDTO(Borrower borrower) {
        BorrowerDTO borrowerDTO = new BorrowerDTO();
        borrowerDTO.setFirstName(borrower.getFirstName());
        borrowerDTO.setLastName(borrower.getLastName());
        borrowerDTO.setPhone(borrower.getBorrowerDetailsId().getPhone()); //zmiana
        borrowerDTO.setAddress(borrower.getBorrowerDetailsId().getAddress());
        borrowerDTO.setEmail(borrower.getBorrowerDetailsId().getEmail());
        return borrowerDTO;
    }

}
