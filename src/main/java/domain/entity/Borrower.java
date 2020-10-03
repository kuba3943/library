package domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name = "borrower")
public class Borrower {

    @Id
    @Column (name = "id_borrower")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "borrower_details_id")
    private BorrowerDetails borrowerDetailsId;

    @OneToMany(mappedBy = "borrowerId", fetch = FetchType.LAZY)
    private Set<Borrow> borrows = new HashSet<>();

    public Borrower ( String firstName, String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setBorrowerDetails (BorrowerDetails borrowerDetails){
        this.borrowerDetailsId=borrowerDetails;
    }

    public void addBorrows(Borrow borrow){
        borrows.add(borrow);
        borrow.setBorrower(this);
    }

}
