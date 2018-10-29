/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.todoapp.models;

import java.util.Date;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * class description goes here.
 */

/**
 * The @JsonIgnoreProperties annotation is used to ignore createdAt field during deserialization.
 * We don’t want clients to send the createdAt value. If they send a value for this field, we’ll simply ignore it.
 */
@Getter
@Setter
@Document(collection = "todos")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Todo {

    /* fields -------------------------------------------------------------- */

    @Id
    private String id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String title;

    private Boolean completed = false;

    private Date createdAt = new Date();

    /* constructors -------------------------------------------------------- */

    public Todo() {
        super();
    }

    public Todo(String title) {
        this.title = title;
    }

    /* public methods ------------------------------------------------------ */

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, title='%s', completed='%s']",
                id, title, completed);
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}