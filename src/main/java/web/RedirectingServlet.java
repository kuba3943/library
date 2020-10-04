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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/red")
public class RedirectingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AuthorRepository authorRepository = new AuthorRepository();
        BookRepository bookRepository = new BookRepository();

        int bookId = Integer.parseInt(req.getParameter("exampleRadios"));
        Book book = bookRepository.read(bookId);

        List<Author> all = authorRepository.findAll();
        req.setAttribute("authors", all);

        List<Category> categories = Arrays.stream(Category.values()).collect(Collectors.toList());
        req.setAttribute("categories", categories);


        switch (req.getParameter("action")) {
            case "back" :
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            case "details":
                req.getRequestDispatcher("/detailsServlet").forward(req, resp);
            case "delete":
                req.getRequestDispatcher("/deleteServlet").forward(req, resp);
            case"add":
                req.getRequestDispatcher("add.jsp").forward(req, resp);
            case "edit":

                Author author = authorRepository.read(book.getAuthorId().getId());
                req.setAttribute("id", bookId);
                req.setAttribute("author2", author);
                req.setAttribute("book", book);
                req.getRequestDispatcher("edit.jsp").forward(req,resp);

            case "borrow":


                if(book.getBorrow()==1){
                    String error = "BOOK IS BORROWED, CHOOSE ANOTHER ONE";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("/show").forward(req, resp);
                } else {
                    req.setAttribute("book", book);
                    req.getRequestDispatcher("/borrowServlet").forward(req, resp);

                }
        }


    }
}
