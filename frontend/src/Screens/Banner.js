import React from "react";
import "./Banner.css";

function Banner() {
  return (
    <header
      className="banner"
      style={{
        backgroundSize: "cover",
        backgroundImage: `url(
        "/avatar.jpg"
        )`,
        backgroundPosition: "center center",
      }}
    >
      <div className="banner_contents">
        <h1 className="banner_title">Avatar: The Last Airbender</h1>

        <h1 className="banner_description">
          In a war-torn world of elemental magic, a young boy reawakens to
          undertake a dangerous mystic quest to fulfill his destiny as the
          Avatar, and bring peace to the world.
        </h1>
      </div>

      <div className="banner--fadeBottom" />
    </header>
  );
}

export default Banner;
