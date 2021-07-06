import React, { useState, useContext } from "react";
import { useHistory } from "react-router-dom";
import { Form } from "../components";
import { HeaderContainer } from "../containers/header";
import { FooterContainer } from "../containers/footer";
import Radio from "@material-ui/core/Radio";
import RadioGroup from "@material-ui/core/RadioGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import FormControl from "@material-ui/core/FormControl";
import FormLabel from "@material-ui/core/FormLabel";
import axios from "axios";
import { Spinner } from "beautiful-react-ui";

import * as ROUTES from "../constants/routes";

export default function SignUp() {
	const history = useHistory();

	const [firstName, setFirstName] = useState("");
	const [emailAddress, setEmailAddress] = useState("");
	const [password, setPassword] = useState("");
	const [value, setValue] = React.useState("user");
	// const [plan, setPlan] = useState({
	// 	planId: 1,
	// 	planName: "Free",
	// });

	const plan1 = {
		planId: 1,
		planName: "Free",
	};
	const plan2 = {
		planId: 2,
		planName: "Premium",
	};
	const [error, setError] = useState("");

	const [showSpinner, setShowSpinner] = useState(false);

	const isInvalid =
		firstName === "" || password === "" || emailAddress === "";

	const handleSignup = (event) => {
		event.preventDefault();
		setShowSpinner(true);

		axios
			.post("http://localhost:8080/users/add", {
				name: firstName,
				email: emailAddress,
				password: password,
				plan: value === "user" ? plan1 : plan2,
			})
			.then(function (response) {
				console.log(response);
			})
			.catch((e) => console.log(e));

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
							placeholder="First name"
							value={firstName}
							onChange={({ target }) =>
								setFirstName(target.value)
							}
						/>
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
						<FormControl component="fieldset">
							<FormLabel
								component="legend"
								style={{
									color: "white",
								}}
							>
								Sign up as
							</FormLabel>
							<RadioGroup
								aria-label="gender"
								name="gender1"
								value={value}
								onChange={handleChange}
								style={{
									color: "white",
								}}
							>
								<FormControlLabel
									value="user"
									control={<Radio />}
									label="User"
								/>
								<FormControlLabel
									value="editor"
									control={<Radio />}
									label="Editor"
								/>
							</RadioGroup>
						</FormControl>
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
							Sign Up
						</Form.Submit>
					</Form.Base>

					<Form.Text>
						Already a user?{" "}
						<Form.Link to="/signin">Sign in now.</Form.Link>
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
