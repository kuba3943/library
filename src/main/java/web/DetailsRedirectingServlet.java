package web;

import domain.entity.Book;
import domain.entity.Borrow;
import persistance.AuthorRepository;
import persistance.BookRepository;
import persistance.BorrowRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/detRed")
public class DetailsRedirectingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookRepository bookRepository = new BookRepository();
        BorrowRepository borrowRepository = new BorrowRepository();

        List<Borrow> allborrows = borrowRepository.findAll();
        List<Borrow> borrowsOf = new ArrayList<>();

        int bookId = Integer.parseInt(req.getParameter("action"));


        for (Borrow a : allborrows) {
            if (a.getBookId().getId() == bookId) {
                borrowsOf.add(a);

                System.out.println("ksdjfhksdjhfksdhf");
            }
        }

        req.setAttribute("historyOfBorrows", borrowsOf);

        req.getRequestDispatcher("history.jsp").forward(req, resp);
    }
}

