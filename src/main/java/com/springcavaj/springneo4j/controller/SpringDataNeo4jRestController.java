package com.springcavaj.springneo4j.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcavaj.springneo4j.exception.SpringDataNeo4jRestException;
import com.springcavaj.springneo4j.model.Movie;
import com.springcavaj.springneo4j.model.MovieRequest;
import com.springcavaj.springneo4j.model.Person;
import com.springcavaj.springneo4j.repository.personRepository;
import com.springcavaj.springneo4j.service.SpringDataNeo4jMovieService;


@RestController
public class SpringDataNeo4jRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataNeo4jRestController.class);
	
	@Autowired
	private personRepository personRestRepository;
	
	@Autowired
	private SpringDataNeo4jMovieService movieRestService;

	@GetMapping("/graph")
	public Map<String, Object> graph(@PathVariable(value = "limit", required = false) Integer limit) {
		return movieRestService.graph(limit == null ? 100 : limit);
	}

	@GetMapping("/allPerson")
    public List<Person> getAllPersonData() {
		LOGGER.info("getAllPersonData -> All Person Data are fetched");
		return personRestRepository.findAll();
    }
	
	@GetMapping("/findSpecificPerson/{name}")
    public List<Person> findPersonByName(@PathVariable(value = "name") String name) {
		LOGGER.info("findPersonByName -> Person with name {} data is fetched", name);
		List<Person> persons = personRestRepository.findByName(name);
		if(CollectionUtils.isEmpty(persons)) {
			throw new SpringDataNeo4jRestException("Persons not found with name", name);
		}
		return persons;
    }
	
	@GetMapping("/allMovies")
    public List<Movie> getAllMovies() {
		LOGGER.info("getAllMovies -> All Movies Data are fetched");
		return movieRestService.getAllMovies();
    }
	
	@GetMapping("/findSpecificMovie/{title}")
    public Movie findMovieByTitle(@PathVariable(value = "title") String title) {
		LOGGER.info("findMovieByTitle -> Movie with title {} is fetched", title);
		Movie movie = movieRestService.findMovieByTitle(title);
		if(null == movie) {
			throw new SpringDataNeo4jRestException("Movie not found with title", title);
		}
		return movie;
    }
	
	@GetMapping("/findMovies/{title}")
    public Collection<Movie> findMovieByTitleContaining(@PathVariable(value = "title") String title) {
		LOGGER.info("findMovieByTitleContaining -> Movie with title containing {} are fetched", title);
		Collection<Movie> movies = movieRestService.findMovieByTitleContaining(title);
		if(CollectionUtils.isEmpty(movies)) {
			throw new SpringDataNeo4jRestException("List of movies not found", title);
		}
		return movies;
    }
	
	@GetMapping("/findMovieActors/{title}")
	public Set<String> findActorsOfAMovie(@PathVariable(value = "title") String title) {
		LOGGER.info("graph -> Actors acting in a Movie {}", title);
		Set<String> actors = movieRestService.findActorsOfAMovie(title);
		if(CollectionUtils.isEmpty(actors)) {
			throw new SpringDataNeo4jRestException("Actors not acted in the movie", title);
		}
	    return actors;
	}
	
	@PostMapping("/saveMovie")
	public Movie saveMovie(@RequestBody MovieRequest movieRequest) {
		LOGGER.info("saveMovie -> Saving a Movie along with Person and Role");
		return movieRestService.saveMovie(movieRequest);
	}
	
}
