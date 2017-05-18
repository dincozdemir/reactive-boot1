package com.dinco.reactiveboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Dinco-WORK on 19.05.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEvent {
    private Movie movie;
    private Date when;
    private String user;
}