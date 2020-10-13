package web;

import domain.entity.Book;
import domain.entity.Borrow;
import persistance.BookRepository;
import persistance.BorrowRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("exampleRadios"));

        BookRepository bookRepository = new BookRepository();
        BorrowRepository borrowRepository = new BorrowRepository();

        List<Borrow> allborrows = borrowRepository.findAll();

        for (Borrow a : allborrows) {
            if (a.getBookId().getId() == bookId){
                a.setBook(null);
                a.setBorrower(null);
                borrowRepository.delete(a.getId());
            }
        }



            bookRepository.delete(bookId);



        List<Book> listOfBooks = bookRepository.findAll();

        req.setAttribute("listOfBooks", listOfBooks);
        req.getRequestDispatcher("show.jsp").forward(req,resp);

    }
}
