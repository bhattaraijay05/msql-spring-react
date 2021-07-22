import React, { useState, useContext } from "react";
import { useHistory } from "react-router-dom";
import { Form } from "../components";
import { HeaderContainer } from "../containers/header";
import { FooterContainer } from "../containers/footer";
import axios from "axios";
import { Spinner } from "beautiful-react-ui";

import * as ROUTES from "../constants/routes";
import { TextField } from "@material-ui/core";

export default function AddMovie() {
	const history = useHistory();

	const [name, setName] = useState("");
	const [description, setDescription] = useState("");
	const [date, setDate] = useState("");
	const [value, setValue] = React.useState("user");
	const [error, setError] = useState("");

	const [showSpinner, setShowSpinner] = useState(false);

	const isInvalid = name === "" || date === "" || description === "";

	const handleSignup = (event) => {
		event.preventDefault();
		setShowSpinner(true);

		axios
			.post("http://localhost:8080/api/add", {
				name,
				description,
				releaseDate: date,
				studio: {
					studioId: 154,
					studioName: "Marvel",
					genre: {
						genreId: 145,
						genreName: "comedy",
					},
				},
				trailer: {
					trailerId: 1599,
					trailerUrl: "https://www.youtube.com/wch?v=TcMBFSGVi1c",
				},
				poster: {
					posterId: 12000,
					posterUrl: "http://localhost:8080/public/a.jpg",
				},
			})
			.then(function (response) {
				history.push("/browse");
			})
			.catch((e) => setError(e.message));

		setShowSpinner(false);
	};

	const handleChange = (event) => {
		setValue(event.target.value);
	};
	return (
		<>
			<HeaderContainer>
				<Form>
					<Form.Title>Sign Up</Form.Title>
					{error && <Form.Error>{error}</Form.Error>}

					<Form.Base onSubmit={handleSignup} method="POST">
						<Form.Input
							placeholder="Name"
							value={name}
							onChange={({ target }) => setName(target.value)}
						/>
						<Form.Input
							placeholder="Description"
							value={description}
							onChange={({ target }) =>
								setDescription(target.value)
							}
						/>
						<TextField
							id="date"
							label="Release Date"
							type="date"
							defaultValue="2017-05-24"
							InputLabelProps={{
								shrink: true,
							}}
							onChange={({ target }) => setDate(target.value)}
							style={{ color: "#fff", backgroundColor: "#fff" }}
						/>
						{showSpinner && (
							<div
								style={{
									display: "flex",
									justifyContent: "center",
									alignItems: "center",
								}}
							>
								{" "}
								<Spinner color="secondary" />
							</div>
						)}
						<Form.Submit
							disabled={isInvalid}
							type="submit"
							data-testid="sign-up"
						>
							Add Movie
						</Form.Submit>
					</Form.Base>
				</Form>
			</HeaderContainer>
			<FooterContainer />
		</>
	);
}
