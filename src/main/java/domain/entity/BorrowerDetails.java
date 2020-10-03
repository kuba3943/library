package domain.entity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table (name = "borrower_details")
public class BorrowerDetails {

    @Id
    @Column (name = "id_borrower_details")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "address")
    private String address;

    @Column (name = "email")
    private String email;

    @Column (name = "phone")
    private String phone;

    @OneToOne(mappedBy = "borrowerDetailsId")
    private Borrower borrower;

    public BorrowerDetails(String address, String email, String phone) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
}
