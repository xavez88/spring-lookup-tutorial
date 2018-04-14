package com.achavez.spring_lookup_tutorial;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
@Scope("prototype")
public class SchoolNotification {

    private String name;
    private Collection<Integer> marks;

    public SchoolNotification() {
        System.out.println("Invoking SchoolNotification() constructor");
        this.marks = new ArrayList<>();
    }

    public SchoolNotification(final String name) {
        System.out.println("Invoking SchoolNotification(" + name + ") constructor");
        this.name = name;
        this.marks = new ArrayList<>();
    }


    public String addMark(final Integer mark) {
        this.marks.add(mark);
        return mark.toString();
    }

}
