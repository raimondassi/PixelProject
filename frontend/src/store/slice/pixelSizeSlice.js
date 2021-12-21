import {createSlice} from "@reduxjs/toolkit";
import {addLocalStorage, getLocalStorage} from "../../storage/localStorage";

const pixelSizeSlice = createSlice({
  name: 'pixelSize',
  initialState: [],
  reducers: {
    addPixelSize(pixelSizeState, action) {
      const pixelSize = action.payload;
      pixelSizeState.push(pixelSize);
        return pixelSizeState;
    },
    removePixelSize(pixelSizeState, {payload: id}) {
      pixelSizeState.delete(id);
      return pixelSizeState;
    }
  }
});

let prevPixelSize = [];
const subscribePixelSizeToStore = (store) => {
  store.subscribe(() => {
    const pixelSize = store.getState().pixelSize;
    if (prevPixelSize !== pixelSize) {
      addLocalStorage('pixelSize', pixelSize);
      prevPixelSize = pixelSize;
    }
  });
}

const loadPixelSizesFromLocalStorage = () => getLocalStorage('pixelSize') || [];

export default pixelSizeSlice.reducer;
export const {addPixelSize, removePixelSize} = pixelSizeSlice.actions;
export {subscribePixelSizeToStore , loadPixelSizesFromLocalStorage}