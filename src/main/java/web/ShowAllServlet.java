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
import java.util.ArrayList;
import java.util.List;

@WebServlet ("/show")
public class ShowAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookRepository bookRepository = new BookRepository();

        List<Book> listOfBooks = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();

        if (req.getParameter("show")!=null) {
            if (req.getParameter("show").equals("ava")) {
                for (Book a : listOfBooks) {
                    if (a.getBorrow() == 0) {
                        bookList.add(a);
                    }
                }
            } else {
                bookList = listOfBooks;
            }
        }else {
            bookList = listOfBooks;
        }

        req.setAttribute("listOfBooks", bookList);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
    }
}
