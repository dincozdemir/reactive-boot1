package com.dinco.reactiveboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Dinco-WORK on 19.05.2017.
 */
@AllArgsConstructor
@Data
@Document
public class Movie {

    private String title;

    @Id
    private String id;
}