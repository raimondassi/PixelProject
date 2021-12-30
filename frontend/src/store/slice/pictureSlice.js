import {createSlice} from "@reduxjs/toolkit";

const pictureSlice = createSlice({
  name: 'picture',
  initialState: "",
  reducers: {
    addPicture(state, action) {
      const picture = action.payload;
      return picture;
    }
  }
});

export default pictureSlice.reducer;
export const {addPicture} = pictureSlice.actions;
