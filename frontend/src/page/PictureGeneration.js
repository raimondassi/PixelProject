import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import ColorAndSlider from '../components/component/ColorAndSlider'
import {Button, Checkbox, FormControlLabel, Stack} from "@mui/material";
import HelperText from "../components/component/HelperText";
import {useDispatch, useSelector} from "react-redux";
import {addOrRemovePixel} from "../store/slice/pixelSlice";
import {generatePicture} from "../api/restApi";
import {addPicture} from "../store/slice/pictureSlice";
import {NavLink} from "react-router-dom";

export default function PictureGeneration() {

  const dispatch = useDispatch();
  const pixelInStore = useSelector(storeState => storeState.pixel);
  const [picture, setPicture] = useState("");
  const user = useSelector(state => state.user.user);

  const onAddOrRemovePixel = (id, size) => {
    const pixel = {id: id, size: size, color: "#000000", procentage: 10};
    dispatch(addOrRemovePixel(pixel));

  }

  const onGeneratePicture = () => {
    generatePicture(pixelInStore)
      .then(({data}) => setPicture(data))
      .catch((error) => console.log(error));

  }

  const onCreateOrder = (product, helpers) => {
    dispatch(addPicture(picture));
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
      </div>
      <div style={{width: '100%'}}>
        <Box sx={{
          display: 'grid',
          gridTemplateColumns: 'repeat(4, 1fr)',
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
          <Button variant="contained"
                  onClick={onGeneratePicture}>
            generate product view
          </Button>
        </Stack>
      </div>
      {picture &&
      <div style={{width: '100%'}}>
        <Box sx={{
          display: 'flex',
          justifyContent: 'space-evenly',
          p: 1,
          m: 1,
          bgcolor: 'background.paper',
        }}>
          <Box component="img" sx={{width: '90%', height: 320, borderRadius: 2}}
               src={`data:image/jpeg;base64,${picture}`}>
          </Box>
        </Box>
        {
          user ?
            <Stack spacing={2} direction="row" justifyContent="center">
              <Button variant="contained"
                      onClick={() => onCreateOrder()}
                      to="/order"
                      component={NavLink}>
                create an order
              </Button>
            </Stack>
            :
            <HelperText name="If you want to order this product you have to login"/>
        }
      </div>
      }
    </>
  );

}
