package com.example.todo;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "todo")
public class TodoModel {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
        initialValue = 1,
        name = "todoSeq",
        sequenceName = "todoSeq"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "todoSeq"
    )
    private Long id;

    @Column(name = "work")
    private String work;

    @Column(name = "food")
    private String food;

    @Column(name = "travel")
    private String travel;

    @Column(name = "created")
    private Instant date;
}
