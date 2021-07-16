import React from "react";
import requests from "../API/requests";
import Banner from "../Screens/Banner";
import Nav from "../Screens/Nav";
import Row from "../Screens/Row";

const Browse = () => {
	return (
		<div className="app">
			<Nav />
			<Banner />

			<div
				style={{
					marginTop: -150,
				}}
			>
				<Row
					title="All Movies"
					id="NO"
					fetchUrl={requests.fetchAll}
					isLargeRow
				/>
			</div>

			<Row
				title="Marvel Movies"
				id="MR"
				fetchUrl={requests.fetchMarvel}
			/>

			<Row
				title="Disney Movies"
				id="DS"
				fetchUrl={requests.fetchDisney}
			/>

			<Row
				title="Movies After 2015"
				id="FI"
				fetchUrl={requests.fetchMovieAfter2015}
			/>

			<Row
				title="Comedy Movie"
				id="CM"
				fetchUrl={requests.fetchComedyMovies}
			/>

			<Row
				title="Action Movie"
				id="AM"
				fetchUrl={requests.fetchActionMovies}
			/>

			{/* <Row title="Top Rated" id="TR" fetchUrl={requests.fetchTopRated} />
			<Row
				title="Action Movies"
				id="AM"
				fetchUrl={requests.fetchActionMovies}
			/>
			<Row
				title="Comedy Movies"
				id="CM"
				fetchUrl={requests.fetchComedyMovies}
			/> */}
		</div>
	);
};

export default Browse;
