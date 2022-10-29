package org.barista.service.member.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity(name="member")
@Table(name="member")
@ToString
@Getter
@NoArgsConstructor
public class MemberEntity extends BaseEntity implements UserDetails {

    @Id
    @Column(name = "mberNo", columnDefinition = "varchar(20)")
    private String mberNo;

    @Column(columnDefinition = "varchar(100)")
    private String mberName;

    @Column(columnDefinition = "varchar(100)")
    private String mberId;

    @Column(columnDefinition = "varchar(100)")
    private String password;

    @Column(columnDefinition = "varchar(100)")
    private String mberPhone;

    @Column(columnDefinition = "varchar(2000)")
    private String address1;

    @Column(columnDefinition = "varchar(100)")
    private String address2;

    @Column(columnDefinition = "varchar(40)")
    private String mberSe;

    @Column(columnDefinition = "varchar(300)")
    private String email;

    @Transient //컬럼생성 x
    private String tokenKey;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(this.mberSe.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Builder
    public MemberEntity(String mberNo, String mberName, String mberId, String password, String mberPhone, String address1, String address2, String mberSe, String email) {
        super();
        this.mberNo = mberNo;
        this.mberName = mberName;
        this.mberId = mberId;
        this.password = password;
        this.mberPhone = mberPhone;
        this.address1 = address1;
        this.address2 = address2;
        this.mberSe = mberSe;
        this.email = email;
    }

    @Override
    public String getUsername() {
        return mberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
