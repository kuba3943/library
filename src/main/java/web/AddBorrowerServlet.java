package web;

import domain.entity.Author;
import domain.entity.Borrower;
import domain.entity.BorrowerDetails;
import domain.entity.Category;
import persistance.AuthorRepository;
import persistance.BorrowerDetailsRepository;
import persistance.BorrowerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet ("/addBorrowerServlet")
public class AddBorrowerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BorrowerRepository borrowerRepository = new BorrowerRepository();
        Borrower borrower = new Borrower();

        BorrowerDetailsRepository borrowerDetailsRepository = new BorrowerDetailsRepository();
        BorrowerDetails borrowerDetails = new BorrowerDetails();

        borrowerDetails.setAddress(req.getParameter("address"));
        borrowerDetails.setEmail(req.getParameter("email"));
        borrowerDetails.setPhone(req.getParameter("phone"));

        borrowerDetailsRepository.create(borrowerDetails);

        borrower.setFirstName(req.getParameter("first"));
        borrower.setLastName(req.getParameter("last"));
        borrower.setBorrowerDetails(borrowerDetails);

        borrowerRepository.create(borrower);


        List<Borrower> all = borrowerRepository.findAll();
        req.setAttribute("borrowers", all);


        req.getRequestDispatcher("borrow.jsp").forward(req,resp);

    }
}
