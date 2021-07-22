import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import {
	Home,
	SignIn,
	SignUp,
	Main,
	SearchPage,
	AddMovie,
	UpdateMovie,
} from "./pages";

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
					<Route exact path="/browse/:admin">
						<Main />
					</Route>
					<Route exact path="/add">
						<AddMovie />
					</Route>
					<Route exact path="/update/:id">
						<UpdateMovie />
					</Route>
				</Switch>
			</Router>
		</div>
	);
}

export default App;
