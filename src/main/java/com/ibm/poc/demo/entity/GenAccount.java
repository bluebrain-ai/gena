package com.ibm.poc.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "GENACUSTOMERGEN")

@Data

@AllArgsConstructor
@NoArgsConstructor
public class GenAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENA_CUST_SEQ")
    @SequenceGenerator(sequenceName = "GENA_CUSTOMER_SEQ", allocationSize = 1, name = "GENA_CUST_SEQ")
    @Column(name = "CUSTOMERNUMBER")
    private Long customerNumer;

    @Column(name = "COMMENTS")
    private String comments;
}
