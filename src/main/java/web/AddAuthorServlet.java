package web;

import domain.entity.Author;
import domain.entity.Category;
import persistance.AuthorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet ("/addAuthorServlet")
public class AddAuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorRepository authorRepository = new AuthorRepository();
        Author author = new Author();

        author.setFirstName(req.getParameter("first"));
        author.setLastName(req.getParameter("last"));
        author.setBirthPlace(req.getParameter("place"));

        authorRepository.create(author);

        List<Author> all = authorRepository.findAll();
        req.setAttribute("authors", all);

        List<Category> categories = Arrays.stream(Category.values()).collect(Collectors.toList());
        req.setAttribute("categories", categories);

        req.getRequestDispatcher("add.jsp").forward(req,resp);

    }
}
