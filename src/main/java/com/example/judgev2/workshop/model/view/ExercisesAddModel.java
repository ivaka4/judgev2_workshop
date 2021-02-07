package com.example.judgev2.workshop.model.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExercisesAddModel {
    @Size(min = 2, message = "Name must be minimum two characters")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "The date cannot be in the future")
    private LocalDateTime startedOn;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past")
    private LocalDateTime dueDate;
}
