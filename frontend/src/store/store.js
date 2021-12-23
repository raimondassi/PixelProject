import pixel from "./slice/pixelSlice";
import localProduct from "./slice/localProductSlice"
import colorPicker from "./slice/colorPickerSlice";
import {logger} from "redux-logger/src";
import {configureStore} from "@reduxjs/toolkit";

const buildStore = () => {
  const store = configureStore({
    reducer: {
      pixel,
      localProduct,
      colorPicker
    },
    middleware: getDefaultMiddleware => getDefaultMiddleware().concat(logger),
    preloadedState: {
      // localProduct: loadLocalProductsFromLocalStorage()

    }
  });
  return store;
}

const store = buildStore();

export default store;