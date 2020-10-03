package domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BorrowerDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;

}
