package ua.holovchenko.module4web.database.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "races")
public class Race {

    @Id
    @Column(name = "start_time")
    private String start_time;

    @OneToMany(mappedBy = "race", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<HorseRun> horseRuns;
}
