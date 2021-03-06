package app.data.entity.embeded;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
public class Birth {

    private String birth_1;
    private String birth_2;
    private String birth_3;

}
