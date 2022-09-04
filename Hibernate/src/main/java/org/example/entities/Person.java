package org.example.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column (name = "cnp")
    private String cnp;
    @Column(name ="nume")
    private String familyName;
    @Column(name="prenume")
    private String name;
    @Column(name ="adress")
    private String adress;
    @Column(name ="phone")
    private String phoneNumber;
    @Column (name ="email")
    private String email;

}
