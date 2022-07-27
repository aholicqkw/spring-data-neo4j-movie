package com.springcavaj.springneo4j;

import com.springcavaj.springneo4j.model.Movie;
import com.springcavaj.springneo4j.model.Person;
import com.springcavaj.springneo4j.model.Role;
import com.springcavaj.springneo4j.repository.movieRepository;
import com.springcavaj.springneo4j.repository.personRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class SpringDataNeo4jRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringDataNeo4jRestApplication.class, args);
	}

}
