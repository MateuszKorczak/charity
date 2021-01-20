package pl.coderslab.charity.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
//    @Pattern(regexp = "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.-]{0,19}$", flags = Pattern.Flag.UNICODE_CASE)
    private String username;


    private String password;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-ZÓŹŻĆŁŚĆ]{1}[a-zóżźćąęłśń]{2,}", message = "Imię musi zaczynać się Wielką literą. Nie może składać się z cyfr ani znaków specjalnych")
    private String firstName;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-ZÓŹŻĆŁŚĆ]{1}[a-zóżźćąęłśń]{2,}", message = "Nazwisko musi zaczynać się Wielką literą. Nie może składać się z cyfr ani znaków specjalnych")
    private String lastName;

    @NotNull
    @NotEmpty
    @Email
    @Column(unique = true, nullable = false)
    @Pattern(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,})", flags = Pattern.Flag.UNICODE_CASE)
    private String email;
}