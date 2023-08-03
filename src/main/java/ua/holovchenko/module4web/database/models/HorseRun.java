package ua.holovchenko.module4web.database.models;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "horse_runs")
public class HorseRun {
    @Id
    @ManyToOne
    @JoinColumn(name = "start_time")
    private Race race;
    @Id
    private int num;

    @Column
    private int place;

    @Column(name = "result")
    private long result;

    @Column
    private boolean isChosen;
}
