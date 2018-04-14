package com.achavez.spring_lookup_tutorial;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public abstract class StudentService {

    private Map<String, SchoolNotification> notes = new HashMap();

    /*
        Spring will override our annotated method and use our method’s return type
        and parameters as arguments to BeanFactory#getBean.
     */
    @Lookup
    public SchoolNotification getSchoolNotification() {
        return null;
    }

    /*
        Using abstract is a bit nicer-looking than a stub, but we can only use it
        when we don’t component-scan or @Bean-manage the surrounding bean
     */
    @Lookup
    public abstract SchoolNotification getSchoolNotification(final String name);

    // ... getters & setters.

    public String appendMark(final String name, final Integer mark) {
        SchoolNotification notification =
                notes.computeIfAbsent(name, exists -> getSchoolNotification(name));
        System.out.println("Getting SchoolNotificationBean with hashcode "
                + notification.hashCode());
        return notification.addMark(mark);
    }
}
