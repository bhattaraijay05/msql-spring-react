import { useState } from "react";
import axios from "axios";
import "./App.css";
import { Button, Spinner } from "beautiful-react-ui";

const URL = "http://localhost:8080";

function App() {
  const [name, setName] = useState("");
  const [backend, setBackend] = useState();
  const [showSpinner, setShowSpinner] = useState(false);

  const sendToBackend = () => {
    setShowSpinner(true);
    axios
      .post(URL, {
        name,
      })
      .then(function (response) {
        setTimeout(() => {
          setBackend(response.data.name);
          setShowSpinner(false);
        }, 1500);
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div className="App">
      <header className="App-header">
        <div>
          <h1>Hello World</h1>
          <div>
            <p>Enter your name</p>
            <input
              type="text"
              name="name"
              id="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </div>
          <div className="mt-4">
            {name && (
              <Button type="submit" color="success" onClick={sendToBackend}>
                Submit
              </Button>
            )}
          </div>

          {showSpinner && <Spinner color="secondary" />}

          {backend && <h3>Text fetched from backend {backend}</h3>}
        </div>
      </header>
    </div>
  );
}

export default App;
