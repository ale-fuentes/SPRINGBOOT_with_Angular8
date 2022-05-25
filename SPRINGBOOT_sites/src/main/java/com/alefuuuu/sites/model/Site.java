package com.alefuuuu.sites.model;

import com.alefuuuu.sites.enumaration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author Ale Fuentes (https://github.com/ale-fuentes)
 * @version 1.0
 * @since 25/05/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "IP Address cannot be empty or null")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;
}
