import React, { useState, useContext } from "react";
import { useHistory, useParams } from "react-router-dom";
import { Form } from "../components";
import { HeaderContainer } from "../containers/header";
import { FooterContainer } from "../containers/footer";
import axios from "axios";
import { Spinner } from "beautiful-react-ui";

import * as ROUTES from "../constants/routes";
import { TextField } from "@material-ui/core";

export default function UpdateMovie() {
	const history = useHistory();
	const id = useParams();
	console.log(id.id);
	const [name, setName] = useState("");
	const [description, setDescription] = useState("");
	const [value, setValue] = React.useState("user");
	const [error, setError] = useState("");

	const [showSpinner, setShowSpinner] = useState(false);

	const isInvalid = name === "" || description === "";

	const handleUpdate = (event) => {
		event.preventDefault();
		axios
			.put(`http://localhost:8080/api/edit/${id.id}`, {
				name,
				description,
			})
			.then(() => {
				history.push("/browse/admin");
			})
			.catch((error) => {
				console.log(error);
			});
	};

	return (
		<>
			<HeaderContainer>
				<Form>
					<Form.Title>Update</Form.Title>
					{error && <Form.Error>{error}</Form.Error>}

					<Form.Base onSubmit={handleUpdate} method="POST">
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
							Update Movie
						</Form.Submit>
					</Form.Base>
				</Form>
			</HeaderContainer>
			<FooterContainer />
		</>
	);
}
