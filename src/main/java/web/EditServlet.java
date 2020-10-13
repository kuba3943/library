package web;

import domain.entity.Author;
import domain.entity.Book;
import domain.entity.Category;
import persistance.AuthorRepository;
import persistance.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();

        Book book = bookRepository.read(Integer.parseInt(req.getParameter("id")));
        Author author = authorRepository.read(Integer.parseInt(req.getParameter("author")));

        book.setCategory(Category.valueOf(req.getParameter("category")));
        book.setBorrow(Byte.parseByte(req.getParameter("borrow")));
        book.setTitle(req.getParameter("title"));
        book.setIsbn(req.getParameter("isbn"));
        book.setAuthor(author);
        book.setPages(Integer.parseInt(req.getParameter("page")));
        book.setSummary(req.getParameter("summary"));
        book.setReleaseDate(Date.valueOf(req.getParameter("date")));
        bookRepository.update(book);

        List<Book> listOfBooks = bookRepository.findAll();

        req.setAttribute("listOfBooks", listOfBooks);
        req.getRequestDispatcher("show.jsp").forward(req, resp);
    }
}
