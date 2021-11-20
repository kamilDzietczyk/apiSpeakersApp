package com.example.speakersapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "user_records")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long record_id;

    private int record_user_id;
    private Date record_date;
    private int record_exercise_id;
    private int record_score;
    private int record_attempts;
    private String record_char;

    public String getRecord_char() {
        return record_char;
    }

    public void setRecord_char(String record_char) {
        this.record_char = record_char;
    }

    public Long getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Long record_id) {
        this.record_id = record_id;
    }

    public int getRecord_user_id() {
        return record_user_id;
    }

    public void setRecord_user_id(int record_user_id) {
        this.record_user_id = record_user_id;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public int getRecord_exercise_id() {
        return record_exercise_id;
    }

    public void setRecord_exercise_id(int record_exercise_id) {
        this.record_exercise_id = record_exercise_id;
    }

    public int getRecord_score() {
        return record_score;
    }

    public void setRecord_score(int record_score) {
        this.record_score = record_score;
    }

    public int getRecord_attempts() {
        return record_attempts;
    }

    public void setRecord_attempts(int record_attempts) {
        this.record_attempts = record_attempts;
    }
}
