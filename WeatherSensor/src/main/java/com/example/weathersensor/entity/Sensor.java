package com.example.weathersensor.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Size(min = 3, max = 30, message = "Размер имени должен быть в диапазоне от 3 до 30 символов.")
    @NotNull(message = "Значение должно быть не пустым.")
    @Column(name = "name", unique = true)
    String name;

    @OneToMany(mappedBy = "sensor")
    @JsonIgnoreProperties("sensor")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    List<Measurement> measurements;
}
