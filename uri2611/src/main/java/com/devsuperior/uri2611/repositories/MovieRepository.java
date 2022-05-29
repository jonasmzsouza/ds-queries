package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(nativeQuery = true, value = "SELECT movies.id, movies.name "
			+ "FROM movies "
			+ "INNER JOIN genres on movies.id_genres = genres.id "
			+ "WHERE LOWER(genres.description) = LOWER(:genreName)")
	List<MovieMinProjection> search1(String genreName);

}
