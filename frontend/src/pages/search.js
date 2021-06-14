import axios from "axios";
import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import MovieModal from "../Screens/MovieModel";
import Nav from "../Screens/Nav";
import "./SearchPage.css";

const SearchPage = () => {
  const base_url = "https://image.tmdb.org/t/p/original/";
  const [movies, setMovies] = useState([]);

  const [modalVisibility, setModalVisibility] = useState(false);
  const [movieSelected, setMovieSelection] = useState({});

  useEffect(() => {
    async function fetchData() {
      const request = await axios.get(
        "https://api.themoviedb.org/3/discover/tv?api_key=896c8566fc255f7c52f6ea6bd2901188&with_networks=213"
      );
      setMovies(request.data.results);
      return request;
    }

    fetchData();
  }, []);

  const handleClick = (movie) => {
    setModalVisibility(true);
    setMovieSelection(movie);
  };
  return (
    <>
      <Nav />
      <section className="row">
        <div
          style={{
            marginBottom: 150,
          }}
        ></div>

        <div className="search_container">
          <>
            {movies.map((movie) => (
              <img
                key={movie.id}
                onClick={() => handleClick(movie)}
                // className={`row__poster ${isLargeRow && "row__posterLarge"}`}
                src={`${base_url}${movie.backdrop_path}
                `}
                className={`search__posterLarge`}
                // src={movie.poster}
                loading="lazy"
                alt={movie.name}
                style={{
                  cursor: "pointer",
                }}
              />
            ))}
          </>

          {!movies && (
            <h1 style={{ color: "white" }}>
              {" "}
              No Movies/Series Found, Please check the name{" "}
            </h1>
          )}
        </div>
        {modalVisibility && (
          <MovieModal
            {...movieSelected}
            setModalVisibility={setModalVisibility}
          />
        )}
      </section>
    </>
  );
};

export default SearchPage;
