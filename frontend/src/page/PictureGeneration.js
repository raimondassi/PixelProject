import * as React from 'react';
import {useEffect, useState} from 'react';
import Box from '@mui/material/Box';
import ColorAndSlider from '../components/component/ColorAndSlider'
import {Button, Checkbox, FormControlLabel, Stack} from "@mui/material";
import HelperText from "../components/component/HelperText";
import {useDispatch, useSelector} from "react-redux";
import {addOrRemovePixel} from "../store/slice/pixelSlice";
import {generatePicture} from "../api/restApi";
import {image} from "../img/123.png"




export default function PictureGeneration() {

  const [selectedPixelSizes, setPixelSizes] = useState();
  const dispatch = useDispatch();
  const pixelInStore = useSelector(storeState => storeState.pixel);

  const onAddOrRemovePixel = (id, size) => {
    const pixel = {id: id, size: size, color:"#000000", procentage:10};
    dispatch(addOrRemovePixel(pixel));

  }
  const [notification, setNotification] = useState({isVisible: false, message:'', severity: ''});
  const [picture, setPicture]=useState();


  function onGeneratePicture(pixelInStore) {
    generatePicture(pixelInStore)
      .then(({data}) => setPicture(data))
      .catch((error) => console.log(error))
  }

  function onCreateOrder(pixelInStore) {

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
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(11, 1)}/>} label="1 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(12, 2)}/>} label="2 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(13, 3)}/>} label="3 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(14, 4)}/>} label="4 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(21, 1)}/>} label="1 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(22, 2)}/>} label="2 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(23, 3)}/>} label="3 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(24, 4)}/>} label="4 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(31, 1)}/>} label="1 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(32, 2)}/>} label="2 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(33, 3)}/>} label="3 mm"/>
          <FormControlLabel control={<Checkbox onClick={() => onAddOrRemovePixel(34, 4)}/>} label="4 mm"/>
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

          {pixelInStore.map((pixel) => (
            <Box sx={{width: '90%'}}>
              <ColorAndSlider size={pixel.size} id={pixel.id}/>
            </Box>
          ))}

        </Box>

        <Stack spacing={2} direction="row" justifyContent="center">
          <Button variant="contained" onClick={onGeneratePicture(pixelInStore)}>generate product view </Button>
        </Stack>
        {console.log(pixelInStore)}
      </div>
      <div style={{width: '100%'}}>
        <Box sx={{
          display: 'flex',
          justifyContent: 'space-evenly',
          p: 1,
          m: 1,
          bgcolor: 'background.paper',
        }}>
          <Box component="img" sx={{width: '90%', height: 300, borderRadius: 2}}>
            {picture}
          </Box>
        </Box>
        <Stack spacing={2} direction="row" justifyContent="center">
          <Button variant="contained" >save for later </Button>
          <Button variant="contained" onClick={() => onCreateOrder(pixelInStore)} >make an order</Button>
        </Stack>
        <HelperText name="please do not save more than 5 pictures"/>
      </div>
    </>
  );

}
