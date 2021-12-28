import Header from "./components/header/Header";
import Content from "./components/content/Content";
import Footer from "./components/footer/Footer";
import {BrowserRouter} from "react-router-dom";
import buildStore from "./store/store";
import {Provider} from "react-redux";
import store from "./store/store";
import LandingPageHeader from "./components/header/LandingPageHeader";

function App() {
  return (
    <Provider store={store}>
    <BrowserRouter>
      <div className="container">
        {/*<LandingPageHeader/>*/}
        <Header/>
        <Content/>
      </div>
    </BrowserRouter>
    </Provider>

  );
}

export default App;