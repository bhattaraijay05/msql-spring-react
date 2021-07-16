import axios from "axios";
import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import MovieModal from "../Screens/MovieModel";
import Nav from "../Screens/Nav";
import "./SearchPage.css";

const SearchPage = () => {
	const [movies, setMovies] = useState([]);

	const [modalVisibility, setModalVisibility] = useState(false);
	const [movieSelected, setMovieSelection] = useState({});

	const { movie } = useParams();

	useEffect(() => {
		async function fetchData() {
			const request = await axios.get(
				`http://localhost:8080/api/movie/${movie}`
			);
			setMovies(request.data);
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
						{movies &&
							movies.map((movie) => (
								<img
									key={movie.id}
									onClick={() => handleClick(movie)}
									className={`search__posterLarge`}
									src={movie.poster.posterUrl}
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
