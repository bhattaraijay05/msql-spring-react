import React, { useState, useEffect } from "react";
import Header from "./header";
import "./Nav.css";
import Button from "@material-ui/core/Button";
import { Link } from "react-router-dom";
// import logo from "/logo.svg";

const picture = "/images/icons/search.png";

function Nav() {
  const [show, handleshow] = useState(false);

  const [searchTerm, setSearchTerm] = useState("");

  useEffect(() => {
    window.addEventListener("scroll", () => {
      if (window.scrollY > 100) {
        handleshow(true);
      } else handleshow(false);
    });

    return () => {
      window.removeEventListener("scroll", null);
    };
  }, []);

  return (
    <div className={`nav ${show && "nav_black"}`}>
      <Header.Frame style={{ height: 30 }}>
        {!searchTerm && (
          <Header.Group>
            {/* <Header.Logo
              to="/browse"
              src="/images/logo/netflix.png"
              alt="Netflix Logo"
            /> */}
          </Header.Group>
        )}

        <Header.Group>
          <Header.Search
            searchTerm={searchTerm}
            setSearchTerm={setSearchTerm}
          />

          {searchTerm && (
            <a
              href={`/search/${searchTerm}`}
              style={{ textDecoration: "none" }}
            >
              <Button variant="contained">Search</Button>
            </a>
          )}

          <Header.Profile>
            <Header.Picture src={picture} />
            <Header.Dropdown>
              <Header.Group>
                <Header.Picture src={picture} />
                <Header.TextLink>illogical</Header.TextLink>
              </Header.Group>
            </Header.Dropdown>
          </Header.Profile>
        </Header.Group>
      </Header.Frame>
    </div>
  );
}

export default Nav;
