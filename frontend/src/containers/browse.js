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

			{/* <Row
				title="Trending Now"
				id="TN"
				fetchUrl={requests.fetchTrending}
			/>
			<Row title="Top Rated" id="TR" fetchUrl={requests.fetchTopRated} />
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
