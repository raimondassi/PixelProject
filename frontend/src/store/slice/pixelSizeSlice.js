import {createSlice} from "@reduxjs/toolkit";
import {addLocalStorage} from "../../storage/localStorage";

const pixelSizeSlice = createSlice({
  name: 'pixelSize',
  initialState: [],
  reducers: {
    addOrRemovePixelSize(request, action) {
      const pixelSize = action.payload;
      const existingPixelSize = request.find(p => p.id === pixelSize.id);
      if (existingPixelSize) {
      return request.filter(p => p.id !== pixelSize.id) //kam tas returnas
     //    return request.delete(p => p.id === pixelSize.id)
      } else {
        request.push(pixelSize);
      }
    }
  }
});

export default pixelSizeSlice.reducer;
export const {addOrRemovePixelSize} = pixelSizeSlice.actions;

