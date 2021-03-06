package app.data.entity.basement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter@NoArgsConstructor
public abstract class Entity_Detail {

    @Id
    private Long idx;

    @CreationTimestamp
    @Column(name = "create_time", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(name = "update_time", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime updateTime;

}
