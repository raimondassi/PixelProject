import Header from "./components/header/Header";
import Content from "./components/content/Content";
import Footer from "./components/footer/Footer";
import {BrowserRouter} from "react-router-dom";
import buildStore from "./store/store";
import {Provider} from "react-redux";

const store = buildStore();

function App() {
  return (
    <Provider store={store}>
    <BrowserRouter>
      <div className="container">
        <Header/>
        <Content/>
        <Footer/>
      </div>
    </BrowserRouter>
    </Provider>

  );
}

export default App;