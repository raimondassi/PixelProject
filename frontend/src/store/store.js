import pixelSize, {loadPixelSizesFromLocalStorage, subscribePixelSizeToStore} from "./slice/pixelSizeSlice";
import localProduct, {loadLocalProductsFromLocalStorage, subscribeLocalProductToStore} from "./slice/localProductSlice"
import colorPicker, {loadColorPickersFromLocalStorage, subscribeColorPickerToStore} from "./slice/colorPickerSlice";

import {logger} from "redux-logger/src";
import {configureStore} from "@reduxjs/toolkit";

const buildStore = () => {
  const store = configureStore({
    reducer: {
      pixelSize,
      localProduct,
      colorPicker
    },
    middleware: getDefaultMiddleware => getDefaultMiddleware().concat(logger),
    preloadedState: {
      pixelSize: loadPixelSizesFromLocalStorage(),
      localProduct: loadLocalProductsFromLocalStorage(),
      colorPicker: loadColorPickersFromLocalStorage()

    }
  });

  subscribePixelSizeToStore(store);
  subscribeLocalProductToStore(store);
  subscribeColorPickerToStore(store);

  return store;
}

export default buildStore;