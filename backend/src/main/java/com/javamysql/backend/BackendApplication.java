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
	// userRepo.save(new User(1, "Name", "jay@gmail.com", "password", plan1));
	// userRepo.save(new User(65, "Name 1", "ab@gmail.com", "newpassword", plan2));
	// userRepo.save(new User(69, "Name 2", "aba@gmail.com", "123456", plan2));
	// userRepo.save(new User(95, "Name 3", "aaav@gmail.com", "111111", plan1));
	// };
	// }

	// @Bean
	// public CommandLineRunner movieMapDemo(MovieRepo movieRepo, PosterRepo
	// posterRepo, StudioRepo studioRepo,
	// TrailerRepo trailerRepo, GenreRepo genreRepo) {
	// return args -> {

	// Genre comedy = new Genre(145, "comedy");
	// Genre drama = new Genre(146, "drama");
	// Genre action = new Genre(146, "action");
	// Genre scifi = new Genre(141, "scifi");
	// Genre romance = new Genre(152, "romance");

	// genreRepo.save(comedy);
	// genreRepo.save(drama);
	// genreRepo.save(action);
	// genreRepo.save(scifi);
	// genreRepo.save(romance);

	// Studio studio1 = new Studio(154, "Marvel", comedy);
	// Studio studio2 = new Studio(155, "Disney", drama);
	// Studio studio3 = new Studio(158, "Paramount", scifi);
	// Studio studio4 = new Studio(185, "Sony", romance);
	// Studio studio5 = new Studio(188, "disney-", scifi);

	// studioRepo.save(studio1);
	// studioRepo.save(studio2);
	// studioRepo.save(studio3);
	// studioRepo.save(studio4);
	// studioRepo.save(studio5);

	// Trailer trailer1 = new Trailer(1574,
	// "https://www.youtube.com/watch?v=TcMBFSGVi1c");
	// Trailer trailer2 = new Trailer(1575,
	// "https://www.youtube.com/watch?v=LKFuXETZUsI");
	// Trailer trailer3 = new Trailer(1580,
	// "https://www.youtube.com/watch?v=2ErnLuJKQA4");
	// Trailer trailer4 = new Trailer(1590,
	// "https://www.youtube.com/watch?v=xbqNb2PFKKA");
	// Trailer trailer5 = new Trailer(1599,
	// "https://www.youtube.com/watch?v=lPpfK1K1qNU");

	// trailerRepo.save(trailer1);
	// trailerRepo.save(trailer2);
	// trailerRepo.save(trailer3);
	// trailerRepo.save(trailer4);
	// trailerRepo.save(trailer5);

	// Poster poster1 = new Poster(12563,
	// "https://m.media-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg");
	// Poster poster2 = new Poster(12565,
	// "https://m.media-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg");
	// Poster hulk = new Poster(12567,
	// "https://image.tmdb.org/t/p/w300//qnngKqAcqfH2pBxDoKu5lxzSbTo.jpg");
	// Poster inchulk = new Poster(12566,
	// "https://image.tmdb.org/t/p/w300//2nBpExDoInX3VreBsIm9qOTqXs8.jpg");
	// Poster ageOfUltron = new Poster(12574,
	// "https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_.jpg");

	// posterRepo.save(poster1);
	// posterRepo.save(poster2);
	// posterRepo.save(hulk);
	// posterRepo.save(inchulk);
	// posterRepo.save(ageOfUltron);

	// // create and save new pages
	// movieRepo.save(new Movie(18, "Avenger", "This is Endgame", "20200518",
	// studio1, trailer1, poster1));
	// movieRepo.save(new Movie(19, "Moana", "This is Moana", "20160503", studio2,
	// trailer2, poster2));
	// movieRepo.save(new Movie(20, "Hulk", "This is hulk movie", "20150503",
	// studio3, trailer3, hulk));
	// movieRepo.save(new Movie(21, "Incredible Hulk", "This is Incredible Hulk",
	// "20140503", studio2, trailer4,
	// inchulk));
	// movieRepo.save(new Movie(22, "Avengers: Age Of Ultron", "This is Avengers:
	// Age Of Ultron", "20110303",
	// studio5, trailer5, ageOfUltron));
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
