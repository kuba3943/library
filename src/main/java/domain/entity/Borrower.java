package domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name = "borrower")
public class Borrower {

    @Id
    @Column (name = "id_borrower")
    private int id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "borrower_details")
    private int borrowerDetailsId;
}
