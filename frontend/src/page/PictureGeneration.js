import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import ColorAndSlider from '../components/component/ColorAndSlider'
import {Button, Checkbox, FormControlLabel, Stack} from "@mui/material";
import HelperText from "../components/component/HelperText";
import {useDispatch, useSelector} from "react-redux";
import {addOrRemovePixelSize} from "../store/slice/pixelSizeSlice";

export default function PictureGeneration() {

  const [selectedPixelSizes, setPixelSizes] = useState();
  const dispatch = useDispatch();
  const pixelSizesInStore = useSelector(storeState => storeState.pixelSize);
  const colorPickerInStore = useSelector(storeState => storeState.colorPicker);

  const onAddOrRemoveColorPicker = (id, size) => {
    const pixelSize = {id: id, size: size};
    dispatch(addOrRemovePixelSize(pixelSize));
  }

  return (
    <>
      <div style={{width: '100%', textAlign: "center"}}>
        Please select fraction sizes you will use
        <Box sx={{
          display: 'grid',
          gridTemplateColumns: 'repeat(4, 1fr)',
          justifyContent: 'center',
          p: 1,
          m: 1,
          bgcolor: 'background.paper'
        }}>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(11, 1)}/>} label="1 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(12, 2)}/>} label="2 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(13, 3)}/>} label="3 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(14, 4)}/>} label="4 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(21, 1)}/>} label="1 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(22, 2)}/>} label="2 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(23, 3)}/>} label="3 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(24, 4)}/>} label="4 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(31, 1)}/>} label="1 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(32, 2)}/>} label="2 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(33, 3)}/>} label="3 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemoveColorPicker(34, 4)}/>} label="4 mm"/>
        </Box>
        <HelperText name="please select not more that 6 pcs"/>
      </div>
      <div style={{width: '100%'}}>
        <Box sx={{
          display: 'grid',
          gridTemplateColumns: 'repeat(3, 1fr)',
          justifyContent: 'center',
          p: 1,
          m: 1,
          bgcolor: 'background.paper'
        }}>

          {pixelSizesInStore.map((pixelSize) => (
            <Box sx={{width: '90%'}}>
              <ColorAndSlider size={pixelSize.size}/>
            </Box>
          ))}

        </Box>

        <Stack spacing={2} direction="row" justifyContent="center">
          <Button variant="contained" >generate product view </Button>
        </Stack>
      </div>
      <div style={{width: '100%'}}>
        <Box sx={{
          display: 'flex',
          justifyContent: 'space-evenly',
          p: 1,
          m: 1,
          bgcolor: 'background.paper',
        }}>
          <Box sx={{width: '90%', height: 300, backgroundColor: "lightblue", borderRadius: 2, textAlign: "center"}}>what
            is this</Box>
        </Box>
        <Stack spacing={2} direction="row" justifyContent="center">
          <Button variant="contained" >save for later </Button>
          <Button variant="contained">make an order</Button>
        </Stack>
        <HelperText name="please do not save more than 5 pictures"/>
      </div>
    </>
  );

}
