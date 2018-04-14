package com.achavez.spring_lookup_tutorial;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // ... member variables, etc

    /*
        Spring will override our annotated method and use our method’s return type
        and parameters as arguments to BeanFactory#getBean.
     */
    @Lookup
    public SchoolNotification getSchoolNotification(){
        return null;
    }

    // ... getters & setters.
}
