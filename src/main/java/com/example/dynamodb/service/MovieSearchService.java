
package com.example.dynamodb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.example.dto.Movie;
import com.example.dynamodb.repositories.MovieRepository;

@Service
public class MovieSearchService {
	  @Autowired
	  private AmazonDynamoDB amazondynamoDB ;
	  
	  
	  
	  private MovieRepository MovieRepository;

	    public MovieSearchService(MovieRepository MovieRepository) {
	        this.MovieRepository = MovieRepository;
	    }

	    public List<Movie> findAllMovies() {
	        return StreamSupport.stream(MovieRepository.findAll().spliterator(), true).collect(Collectors.toList());
	    }
	    
	    public Movie findByMovieId(String movieId) {
	        return MovieRepository.findById(movieId).orElse(null);
	    }


	    
	    
	    
	    

}


