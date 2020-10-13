package web;

import domain.entity.*;
import persistance.AuthorRepository;
import persistance.BookRepository;
import persistance.BorrowRepository;
import persistance.BorrowerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/borrowServlet")
public class BorrowServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));

        BorrowerRepository borrowerRepository = new BorrowerRepository();

        BorrowRepository borrowRepository = new BorrowRepository();

        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();
        bookRepository.read(bookId).setBorrow((byte)1);

        List<Author> all = authorRepository.findAll();
        req.setAttribute("authors", all);

        List<Category> categories = Arrays.stream(Category.values()).collect(Collectors.toList());
        req.setAttribute("categories", categories);

        Borrower borrower = borrowerRepository.read(Integer.parseInt(req.getParameter("borrower")));
        Borrow borrow = new Borrow();

        borrow.setBook(bookRepository.read(bookId));
        borrow.setBorrower(borrower);
        borrow.setRentalDate(Date.valueOf(LocalDate.now()));

        borrowRepository.create(borrow);

        bookRepository.read(bookId).setBorrow((byte)1);
        bookRepository.read(bookId).getBorrows().add(borrow);

        List<Book> listOfBooks = bookRepository.findAll();

        req.setAttribute("listOfBooks", listOfBooks);
        req.getRequestDispatcher("/show").forward(req, resp);


    }
}
