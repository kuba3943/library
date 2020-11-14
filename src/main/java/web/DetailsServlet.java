package web;


import domain.dto.BookDTO;
import domain.entity.Book;
import domain.entity.Borrow;
import domain.entity.Borrower;
import persistance.BookRepository;
import persistance.BorrowRepository;
import persistance.BorrowerRepository;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/detailsServlet")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("exampleRadios"));
        System.out.println(bookId);
        BorrowerRepository borrowerRepository = new BorrowerRepository();
        BookRepository bookRepository = new BookRepository();


        List<Borrower> borrowers = borrowerRepository.findAll();
        req.setAttribute("borrowers", borrowers);

        BorrowRepository borrowRepository = new BorrowRepository();
        List<Borrow> borrows = borrowRepository.findAll();


        req.setAttribute("borrows", borrows);

        BookService service = new BookService();
        Book book = bookRepository.read(bookId);
        BookDTO bookDTO = service.convertToBookDTO(book);


        Borrower borrower = new Borrower();

        for (Borrow a: borrows) {
            if(a.getBookId().getId() == bookId && a.getBookId().getBorrow()==1){
                borrower = a.getBorrowerId();
            }
        }
        req.setAttribute("borrower", borrower);


        req.setAttribute("book", bookDTO);
        req.getRequestDispatcher("details.jsp").forward(req,resp);

    }
}
