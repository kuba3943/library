package web;

import domain.entity.Book;
import persistance.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/Home")
public class HomeServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookRepository bookRepository = new BookRepository();
        List<Book> listOfBooks = bookRepository.findAll();

        HttpSession session = req.getSession();

        session.setAttribute("listOfBooks", listOfBooks);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
