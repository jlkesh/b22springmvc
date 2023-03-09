package dev.jlkeesh.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AuthRole {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String code;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "auth_role_permissions",
            joinColumns = @JoinColumn(name = "auth_role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_permission_id", referencedColumnName = "id")
    )
    private Collection<AuthPermission> authPermissions;

}
