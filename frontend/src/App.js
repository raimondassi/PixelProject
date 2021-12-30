import Header from "./components/header/Header";
import Content from "./components/content/Content";
import {BrowserRouter} from "react-router-dom";
import store from "./store/store";
import {Provider} from "react-redux";
import MyFooter from "./components/footer/MyFooter";

function App() {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <div className="container">
          <Header/>
          <Content/>
          {/*<Footer/>*/}
          <MyFooter/>
        </div>
      </BrowserRouter>
    </Provider>
  );
}

export default App;