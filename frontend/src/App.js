import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { Home, SignIn, SignUp, Main, SearchPage } from "./pages";

function App() {
	return (
		<div className="app">
			<Router>
				<Switch>
					<Route exact path="/">
						<Home />
					</Route>
					<Route exact path="/signin">
						<SignIn />
					</Route>
					<Route exact path="/signup">
						<SignUp />
					</Route>

					<Route exact path="/search/:movie">
						<SearchPage />
					</Route>
					<Route exact path="/browse">
						<Main />
					</Route>
				</Switch>
			</Router>
		</div>
	);
}

export default App;
