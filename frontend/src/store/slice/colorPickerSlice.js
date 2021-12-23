import {createSlice} from "@reduxjs/toolkit";
import {addLocalStorage, getLocalStorage} from "../../storage/localStorage";

const colorPickerSlice = createSlice({
  name: 'colorPicker',
  initialState: [],
  reducers: {
    addColorPicker(colorPickerState, action) {
      const colorPicker = action.payload;
      colorPickerState.push(colorPicker);
        return colorPickerState;
    },
    removeColorPicker(colorPickerState, {payload: id}) {
      colorPickerState.delete(id);
      return colorPickerState;
    }
  }
});

let prevColorPicker = [];
const subscribeColorPickerToStore = (store) => {
  store.subscribe(() => {
    const colorPicker = store.getState().colorPicker;
    if (prevColorPicker !== colorPicker) {
      addLocalStorage('colorPicker', colorPicker);
      prevColorPicker = colorPicker;
    }
  });
}

// const loadColorPickersFromLocalStorage = () => getLocalStorage('colorPicker') || [];

export default colorPickerSlice.reducer;
export const {addColorPicker, removeColorPicker} = colorPickerSlice.actions;
export {subscribeColorPickerToStore
  // , loadColorPickersFromLocalStorage
}