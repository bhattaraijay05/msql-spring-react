import { useState, useEffect } from "react";
import axios from "../API/axios";
import "./Row.css";
import ArrowForwardIosIcon from "@material-ui/icons/ArrowForwardIos";
import ArrowBackIosIcon from "@material-ui/icons/ArrowBackIos";
import MovieModal from "./MovieModel";

const Row = ({ title, fetchUrl, isLargeRow, id }) => {
	const [movies, setMovies] = useState([]);
	const [modalVisibility, setModalVisibility] = useState(false);
	const [movieSelected, setMovieSelection] = useState({});

	useEffect(() => {
		async function fetchData() {
			const request = await axios.get(fetchUrl);
			console.log(request);

			setMovies(request.data);
			return request;
		}

		fetchData();
	}, [fetchUrl]);

	const handleClick = (movie) => {
		setModalVisibility(true);
		setMovieSelection(movie);
	};
	return (
		<section className="row">
			<h2>{title}</h2>
			<div class="slider">
				<div
					className="slider__arrow-left"
					onClick={() => {
						document.getElementById(id).scrollLeft -=
							window.innerWidth - 80;
					}}
				>
					<span className="arrow">
						<ArrowBackIosIcon />
					</span>
				</div>
				<div id={id} className="row__posters">
					{movies.map((movie) => (
						<img
							key={movie.id}
							onClick={() => handleClick(movie)}
							className={"row__posterLarge"}
							src={`${
								isLargeRow
									? movie.poster.posterUrl
									: movie.poster.posterUrl
							}`}
							loading="lazy"
							alt={movie.name}
							style={{
								cursor: "pointer",
							}}
						/>
					))}
				</div>
				<div
					className="slider__arrow-right"
					onClick={() => {
						document.getElementById(id).scrollLeft +=
							window.innerWidth - 80;
					}}
				>
					<span className="arrow">
						<ArrowForwardIosIcon />
					</span>
				</div>
			</div>
			{modalVisibility && (
				<MovieModal
					{...movieSelected}
					setModalVisibility={setModalVisibility}
				/>
			)}
		</section>
	);
};

export default Row;
