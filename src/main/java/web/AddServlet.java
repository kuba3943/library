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
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private static Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();

        Author author = authorRepository.read(Integer.parseInt(req.getParameter("author")));
        List<Author> all = authorRepository.findAll();
        req.setAttribute("authors", all);

        List<Category> categories = Arrays.stream(Category.values()).collect(Collectors.toList());
        req.setAttribute("categories", categories);

        Book book = new Book();


        book.setCategory(Category.valueOf(req.getParameter("category")));
        book.setBorrow(Byte.parseByte(req.getParameter("borrow")));
        book.setTitle(req.getParameter("title"));
        book.setIsbn(req.getParameter("isbn"));
        book.setAuthor(author);
        book.setPages(Integer.parseInt(req.getParameter("page")));
        book.setSummary(req.getParameter("summary"));
        book.setReleaseDate(Date.valueOf(req.getParameter("date")));
        // bookRepository.delete(Integer.parseInt(req.getParameter("id")));

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Set<ConstraintViolation<Book>> constraintViolations =
                validator.validate(book);

        System.out.println(constraintViolations.size());


        if( constraintViolations.size()>0){
            req.setAttribute("validation", constraintViolations);
            req.getRequestDispatcher("add.jsp").forward(req, resp);
        } else {

            bookRepository.create(book);


            List<Book> listOfBooks = bookRepository.findAll();

            req.setAttribute("listOfBooks", listOfBooks);
            req.getRequestDispatcher("show.jsp").forward(req, resp);
        }



    }
}
