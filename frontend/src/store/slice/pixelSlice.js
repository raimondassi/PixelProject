import {createSlice} from "@reduxjs/toolkit";

const pixelSlice = createSlice({
  name: 'pixel',
  initialState: [],
  reducers: {
    addOrRemovePixel(state, action) {
      const pixel = action.payload;
      const existingPixel = state.find(p => p.id === pixel.id);
      if (existingPixel) {
        return state.filter(p => p.id !== pixel.id)
      } else {
        state.push(pixel);
      }
    },
    addPercentValue(state, action) {
      const request = action.payload;
      const existingPixel = state.find(p => p.id === request.id);
      existingPixel.procentage = request.procentage;
    },
    addColor(state, action) {
      const color = action.payload;
      const existingPixel = state.find(p => p.id === color.id);
      existingPixel.color = color.color;
    }
  }
});

export default pixelSlice.reducer;
export const {addOrRemovePixel, addPercentValue, addColor} = pixelSlice.actions;

