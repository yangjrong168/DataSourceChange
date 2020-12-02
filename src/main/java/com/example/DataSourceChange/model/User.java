package com.example.DataSourceChange.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private String name;

    private String password;
}
