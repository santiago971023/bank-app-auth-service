package co.com.bancolombia.r2dbc.entities;

import co.com.bancolombia.model.user.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String address;
    private String phone;
    private BigDecimal salary;
    private Role role;

}
