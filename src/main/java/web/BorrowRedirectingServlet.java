package web;

import domain.entity.Book;
import persistance.AuthorRepository;
import persistance.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/borrowRed")
public class BorrowRedirectingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();

        switch (req.getParameter("action")){
            case "back":
                List<Book> listOfBooks = bookRepository.findAll();
                req.setAttribute("listOfBooks", listOfBooks);
                req.getRequestDispatcher("show.jsp").forward(req, resp);
            case "add_borrower":
                req.getRequestDispatcher("addBorrower.jsp").forward(req, resp);
        }




    }
}
