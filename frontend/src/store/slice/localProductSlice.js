import {createSlice} from "@reduxjs/toolkit";
import {addLocalStorage, getLocalStorage} from "../../storage/localStorage";

const localProductSlice = createSlice({
  name: 'localProduct',
  initialState: [],
  reducers: {
    addLocalProduct(state, action) {
      const localProduct = action.payload;
        state.push(localProduct);
    },
    removeLocalProduct(state, {payload: id}) {
      return state.removeLocalProduct(state, {payload: id});
    }
  }
});

let prevLocalProduct = [];
const subscribeLocalProductToStore = (store) => {
  store.subscribe(() => {
    const localProduct = store.getState().localProduct;
    if (prevLocalProduct !== localProduct) {
      addLocalStorage('localProduct', localProduct);
      prevLocalProduct = localProduct;
    }
  });
}

// const loadLocalProductsFromLocalStorage = () => getLocalStorage('localProduct') || [];

export default localProductSlice.reducer;
export const {addLocalProduct, removeLocalProduct} = localProductSlice.actions;
export {subscribeLocalProductToStore
  // , loadLocalProductsFromLocalStorage
}