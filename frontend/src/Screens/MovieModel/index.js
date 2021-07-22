import React, { useEffect, useState } from "react";
import "./MovieModel.css";
import Youtube from "react-youtube";
import { useParams, useHistory } from "react-router-dom";
import movieTrailer from "movie-trailer";
import CancelIcon from "@material-ui/icons/Cancel";
import axios from "axios";

const MovieModal = ({
	poster,
	name,
	description,
	releaseDate,
	setModalVisibility,
	trailer,
	movieId,
}) => {
	const [trailerUrl, setTrailerUrl] = useState("");
	const { admin } = useParams();
	const history = useHistory();
	const opts = {
		height: "390",
		width: "100%",
		playerVars: {
			autoplay: 1,
		},
	};
	const randomPorcentaje = () => {
		return Math.floor(Math.random() * 100);
	};

	const deleteMovie = () => {
		axios.delete(`http://localhost:8080/api/delete/${movieId}`);
		setModalVisibility(false);
		window.location.reload();
	};

	return (
		<div className="presentation" role="presentation">
			<div className="wrapper-modal">
				<div className="modal">
					<span
						onClick={() => setModalVisibility(false)}
						className="modal-close"
					>
						<CancelIcon />
					</span>

					<Youtube
						videoId={trailer.trailerUrl.slice(
							trailer.trailerUrl.length - 11
						)}
						opts={opts}
					/>

					<div className="modal__content">
						<p className="modal__details">
							<span className="modal__user-perc">
								{randomPorcentaje()}% for you
							</span>{" "}
							{releaseDate}
						</p>

						{admin && (
							<div>
								<button
									className="play__button"
									onClick={deleteMovie}
								>
									Delete
								</button>
							</div>
						)}

						<h2 className="modal__title">{name ? name : name}</h2>
						<p className="modal__overview">{description}</p>
					</div>
				</div>
			</div>
		</div>
	);
};

export default MovieModal;
