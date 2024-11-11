package com.example.weathersensor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "maesurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    Integer id;

    @Min(value = -100, message = "Значение должно быть больше -100.")
    @Max(value = 100, message = "Значение должно быть меньше 100.")
    @Column(name = "value")
    @NotNull(message = "Значение должно быть не пустым.")
    Double value;

    @Column(name = "raining")
    @NotNull(message = "Значение должно быть не пустым.")
    Boolean raining;

    //@NotEmpty
    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    Sensor sensor;

    public Measurement(Double value, Boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }
}
