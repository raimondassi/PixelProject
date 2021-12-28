import pixel from "./slice/pixelSlice";
import picture from "./slice/pictureSlice"
import user from "./slice/userSlice";
import {logger} from "redux-logger/src";
import {configureStore} from "@reduxjs/toolkit";

const buildStore = () => {
  const store = configureStore({
    reducer: {
      pixel,
      picture,
      user
    },
    middleware: getDefaultMiddleware => getDefaultMiddleware().concat(logger),
    preloadedState: {

    }
  });
  return store;
}

const store = buildStore();

export default store;