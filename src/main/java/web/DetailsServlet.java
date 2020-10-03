package web;


import domain.dto.BookDTO;
import domain.entity.Book;
import persistance.BookRepository;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detailsServlet")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("exampleRadios"));

        BookRepository bookRepository = new BookRepository();

        BookService service = new BookService();

        Book book = bookRepository.read(bookId);

        BookDTO bookDTO = service.convertToBookDTO(book);

        req.setAttribute("book", bookDTO);
        req.getRequestDispatcher("details.jsp").forward(req,resp);

    }
}
