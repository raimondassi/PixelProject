import {createSlice} from "@reduxjs/toolkit";

const pictureSlice = createSlice({
  name: 'picture',
  initialState: [],
  reducers: {
    addPicture(state, action) {
      const picture = action.payload;
      state.push(picture);
      // return state.filter(picture)
      },
    }
});

export default pictureSlice.reducer;
export const {addPicture} = pictureSlice.actions;
