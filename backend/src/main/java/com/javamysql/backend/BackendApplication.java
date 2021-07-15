package com.javamysql.backend;

import com.javamysql.backend.model.Genre;
import com.javamysql.backend.model.Movie;
import com.javamysql.backend.model.Plan;
import com.javamysql.backend.model.Poster;
import com.javamysql.backend.model.Studio;
import com.javamysql.backend.model.Trailer;
import com.javamysql.backend.model.User;
import com.javamysql.backend.repository.GenreRepo;
import com.javamysql.backend.repository.MovieRepo;
import com.javamysql.backend.repository.PlanRepo;
import com.javamysql.backend.repository.PosterRepo;
import com.javamysql.backend.repository.StudioRepo;
import com.javamysql.backend.repository.TrailerRepo;
import com.javamysql.backend.repository.UserRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner userMapDemo(PlanRepo planRepo, UserRepo userRepo) {
	// return args -> {

	// // create a new book
	// Plan plan1 = new Plan(1, "Free");
	// Plan plan2 = new Plan(2, "Premium");
	// // save the book
	// planRepo.save(plan1);
	// planRepo.save(plan2);

	// // create and save new pages
	// userRepo.save(new User(1, "Name", "aa@gmail.com", "Introduction", plan1));
	// userRepo.save(new User(65, "More Name", "ab@gmail.com", "Java 8", plan2));
	// userRepo.save(new User(69, "More Name", "aba@gmail.com", "Java 8", plan2));
	// userRepo.save(new User(95, "More name", "aaav@gmail.com", "Concurrency",
	// plan1));
	// };
	// }

	// @Bean
	// public CommandLineRunner movieMapDemo(MovieRepo movieRepo, PosterRepo
	// posterRepo, StudioRepo studioRepo,
	// TrailerRepo trailerRepo, GenreRepo genreRepo) {
	// return args -> {

	// Genre genre1 = new Genre(145, "comedy");
	// Genre genre2 = new Genre(146, "drama");

	// genreRepo.save(genre1);
	// genreRepo.save(genre2);

	// Studio studio1 = new Studio(154, "Marvel", genre1);
	// Studio studio2 = new Studio(155, "Disney", genre2);

	// studioRepo.save(studio1);
	// studioRepo.save(studio2);

	// Trailer trailer1 = new Trailer(1574,
	// "https://www.youtube.com/watch?v=TcMBFSGVi1c");
	// Trailer trailer2 = new Trailer(1575,
	// "https://www.youtube.com/watch?v=LKFuXETZUsI");

	// trailerRepo.save(trailer1);
	// trailerRepo.save(trailer2);

	// Poster poster1 = new Poster(12563,
	// "https://m.media-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg");
	// Poster poster2 = new Poster(12565,
	// "https://m.media-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg");

	// posterRepo.save(poster1);
	// posterRepo.save(poster2);

	// // create and save new pages
	// movieRepo.save(new Movie(18, "Avenger", "This is Endgame", "20200518",
	// studio1, trailer1, poster1));
	// movieRepo.save(new Movie(19, "Moana", "This is Moana", "20160503", studio2,
	// trailer2, poster2));
	// };
	// }

}

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication
// @RestController
// @CrossOrigin(origins = "*", allowedHeaders = "*")
// public class BackendApplication {

// public static void main(String[] args) {
// SpringApplication.run(BackendApplication.class, args);
// }

// @GetMapping("/hello")
// public String hello(@RequestParam(value = "name", defaultValue = "Jay")
// String name) {
// return String.format("Hello, My name is %s", name);
// }

// @GetMapping("/")
// public String index() {
// return String.format("Your app is sucessfully running");
// }

// @PostMapping("/")
// public String postBody(@RequestBody String fullName) {
// return fullName;
// }

// }
