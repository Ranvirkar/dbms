package com.blogs.Entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Railway")
public class Railway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "railway_id")
    private Long id;

    @NotBlank(message = "Train name is mandatory")
    @Column(name = "train_name")
    private String trainName;

    @NotNull(message = "Category is mandatory")
    @Column(name = "categories")
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull(message = "Start time is mandatory")
    @Column(name = "start_time")
    private LocalTime startTime;

    @NotNull(message = "End time is mandatory")
    @Column(name = "end_time")
    private LocalTime endTime;

    @NotBlank(message = "Source is mandatory")
    @Column(name = "source")
    private String source;

    @NotBlank(message = "Destination is mandatory")
    @Column(name = "destination")
    private String destination;

    @NotNull(message = "Distance is mandatory")
    @Column(name = "distance")
    private double distance;

    @NotBlank(message = "Frequency is mandatory")
    @Column(name = "frequency")
    private String frequency;
    
    @NotNull(message = "Station code is mandatory")
    @Column(name = "station_code")
    private int stationCode;
}
