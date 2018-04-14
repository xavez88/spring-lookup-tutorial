# Spring @Lookup annotation tutorial.
### This is a quick proof of concept of Spring's method-level dependency injection support via the @Lookup annotation. It is based on Baeldung's tutorial ["@Lookup annotation in Spring"](http://www.baeldung.com/spring-lookup).

## Limitations:
    - @Lookup-annotated methods, like getNotification, must be concrete when the surrounding class, like Student,
    is component-scanned. *This is because component scanning skips abstract beans.*
    - @Lookup-annotated methods won’t work at all when the surrounding class is @Bean-managed.