package com.example.rest_service;

/* Resource Representation Class
To model the greeting representation, create a resource representation class. To do so, provide a Java record class for the id and content data, as the following listing shows:
*/ 
public record Greeting(long id, String content) { }

