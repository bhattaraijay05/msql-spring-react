import { useState, useEffect } from "react";
import Header from "./header";

import "./Nav.css";

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
      window.removeEventListener("scroll");
    };
  }, []);

  const logOut = () => {
    console.log("Log Out");
  };

  return (
    <div className={`nav ${show && "nav_black"}`}>
      <Header.Frame style={{ height: 30 }}>
        <Header.Group>
          <Header.Logo src="/images/logo/netflix.png" alt="Netflix Logo" />
        </Header.Group>
        <Header.Group>
          <Header.Search
            searchTerm={searchTerm}
            setSearchTerm={setSearchTerm}
          />
          <Header.Profile>
            <Header.Picture src={picture} />
            <Header.Dropdown>
              <Header.Group>
                <Header.Picture src={picture} />
                <Header.TextLink>illogical</Header.TextLink>
              </Header.Group>

              <Header.Group>
                <Header.TextLink onClick={logOut}>Sign out</Header.TextLink>
              </Header.Group>
            </Header.Dropdown>
          </Header.Profile>
        </Header.Group>
      </Header.Frame>
    </div>
  );
}

export default Nav;
