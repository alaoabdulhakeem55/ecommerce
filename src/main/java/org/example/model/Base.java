package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Base {
    private String id;

    public Base(String id) {
        this.id = id;
    }
}
