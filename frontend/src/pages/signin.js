import React, { useState, useContext } from "react";
import { useHistory } from "react-router-dom";
import { Form } from "../components";
import { HeaderContainer } from "../containers/header";
import { FooterContainer } from "../containers/footer";
import { Spinner } from "beautiful-react-ui";
import * as ROUTES from "../constants/routes";
import axios from "axios";

export default function SignIn() {
	const history = useHistory();

	const [emailAddress, setEmailAddress] = useState("");
	const [password, setPassword] = useState("");
	const [error, setError] = useState("");

	const [showSpinner, setShowSpinner] = useState(false);

	const isInvalid = password === "" || emailAddress === "";

	const handleSignin = (event) => {
		event.preventDefault();

		setShowSpinner(true);

		setTimeout(() => {
			setShowSpinner(false);
		}, 1500);

		axios
			.get("http://localhost:8080/users/all")
			.then(function (response) {
				console.log(response.data);
				if (response.data) {
					for (var i = 0; i < response.data.length; i++) {
						if (
							response.data[i].email === emailAddress &&
							response.data[i].password === password
						) {
							localStorage.setItem("useristhere", "user");
							history.push("/browse");
						} else {
							setError("No user found");
						}
					}
				}
			})
			.catch((e) => setError(e.message));
	};

	return (
		<>
			<HeaderContainer>
				<Form>
					<Form.Title>Sign In</Form.Title>
					{error && (
						<Form.Error data-testid="error">{error}</Form.Error>
					)}

					<Form.Base onSubmit={handleSignin} method="POST">
						<Form.Input
							placeholder="Email address"
							type="email"
							value={emailAddress}
							onChange={({ target }) =>
								setEmailAddress(target.value)
							}
						/>
						<Form.Input
							type="password"
							value={password}
							autoComplete="off"
							placeholder="Password"
							onChange={({ target }) => setPassword(target.value)}
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
							data-testid="sign-in"
						>
							Sign In
						</Form.Submit>
					</Form.Base>

					<Form.Text>
						New to Netflix?{" "}
						<Form.Link to="/signup">Sign up now.</Form.Link>
					</Form.Text>
					<Form.TextSmall>
						This page is protected by Google reCAPTCHA to ensure
						you're not a bot. Learn more.
					</Form.TextSmall>
				</Form>
			</HeaderContainer>
			<FooterContainer />
		</>
	);
}
