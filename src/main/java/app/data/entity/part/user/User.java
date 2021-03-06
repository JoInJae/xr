package app.data.entity.part.user;

import app.data.entity.embeded.Birth;
import app.data.entity.embeded.Email;
import app.data.entity.part.log.LogV1;
import app.data.entity.basement.Entity_Main;
import app.data.entity.part.log.LogV2;
import app.data.entity.part.log.LogV3;
import app.data.type.Gender;
import app.data.type.Production;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity@Table(name = "User")
@Getter@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "idx", column = @Column(name = "user_idx",  columnDefinition = "BIGINT", nullable = false)),
        @AttributeOverride(name = "uuid", column = @Column(name = "user_uuid",  columnDefinition = "VARCHAR(32)", nullable = false, unique = true))
})
public class User extends Entity_Main {

    @Column(name = "user_name", columnDefinition = "VARCHAR(10)", nullable = false)
    private String name;

    @AttributeOverrides({
            @AttributeOverride(name = "birth_1", column = @Column(name = "user_birth_year", columnDefinition = "CHAR(4)", nullable = false)),
            @AttributeOverride(name = "birth_2", column = @Column(name = "user_birth_month", columnDefinition = "CHAR(2)", nullable = false)),
            @AttributeOverride(name = "birth_3", column = @Column(name = "user_birth_date", columnDefinition = "CHAR(2)", nullable = false)),
    })
    @Embedded
    private Birth birth;


    @AttributeOverrides({
            @AttributeOverride(name = "email_1", column = @Column(name = "user_email_id", columnDefinition = "VARCHAR(30)")),
            @AttributeOverride(name = "email_2", column = @Column(name = "user_email_agency", columnDefinition = "VARCHAR(20)"))
    })
    @Embedded
    private Email email;

    @Column(name = "user_gender", columnDefinition = "CHAR(1)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "user_education", columnDefinition = "INT(2)", nullable = false)
    private Long education;


    @Column(name = "production", columnDefinition = "VARCHAR(10)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Production production;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private final Set<LogV1> v1_logs= new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private final Set<LogV2> v2_logs = new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private final Set<LogV3> v3_logs = new LinkedHashSet<>();

    @Builder
    public User(String name, Gender gender, String email_id, String email_agency, String year, String month, String date, Long education, Production production) {
        this.name = name;
        this.birth = new Birth(year, month, date);
        this.email = new Email(email_id, email_agency);
        this.gender = gender;
        this.education = education;
        this.production = production;
    }

}
