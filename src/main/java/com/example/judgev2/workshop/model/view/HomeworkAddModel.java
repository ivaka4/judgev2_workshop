package com.example.judgev2.workshop.model.view;

import com.example.judgev2.workshop.util.Unique;
import com.example.judgev2.workshop.util.Validate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class HomeworkAddModel {
    @NotNull
    private String exercise;
    @NotNull
    @Validate
    private String gitAddress;
}
