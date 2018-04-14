package com.achavez.spring_lookup_tutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class StudentServiceTest {

    @Autowired private ApplicationContext context;

    @Test
    public void whenLookupMethodCalled_thenNewInstanceReturned() {

        // ... initialize context
        StudentService first = this.context.getBean(StudentService.class);
        StudentService second = this.context.getBean(StudentService.class);

        assertEquals(first, second);
        assertNotSame(first.getSchoolNotification(),second.getSchoolNotification());

    }

    @Test
    public void whenAbstractGetterMethodInjects_thenNewInstanceReturned(){
        StudentService service = this.context.getBean(StudentService.class);
        assertEquals("89", service.appendMark("Antonio",89));
        assertEquals("59", service.appendMark("Sam",59));
        assertEquals("100", service.appendMark("Ben",100));
        assertEquals("100", service.appendMark("Sam",100));
        assertEquals("59", service.appendMark("Ben",59));
        assertEquals("50", service.appendMark("Manolo",50));
    }
}
