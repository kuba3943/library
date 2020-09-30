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

@Table (name = "borrower_details")
public class BorrowerDetails {

    @Id
    @Column (name = "id_borrower_details")
    private int id;

    @Column (name = "address")
    private String address;

    @Column (name = "email")
    private String email;

    @Column (name = "phone")
    private String phone;
}
