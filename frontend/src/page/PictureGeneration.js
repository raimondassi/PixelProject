import * as React from 'react';
import Box from '@mui/material/Box';
import ColorAndSlider from '../components/component/ColorAndSlider'
import {Button, Stack} from "@mui/material";
import PixelSizeSelector from '../components/component/PixelSizeSelector'
import OneCenterButton from "../components/component/OneCenterButton";
import HelperText from "../components/component/HelperText";
import {useState} from "react";
import PixelSelect from "../components/component/PixelSelect"

export default function FlexShrink() {

  const [colorAndSlider, setColorAndSliderStore]=useState([]);
console.log(colorAndSlider);



  return (
    <>
      <div style={{width: '100%', textAlign: "center"}}>
        Please select which pixel sizes you will use
        <Box sx={{
          display: 'flex',
          justifyContent: 'space-evenly',
          bgcolor: 'background.paper',
        }}>

          <Box sx={{width: 'auto'}}>
            <PixelSizeSelector/>
          </Box>

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

          <Box sx={{width: '90%'}} onChange={setColorAndSliderStore}>
            <ColorAndSlider/>
          </Box>
          <Box sx={{width: '90%'}}>
            <ColorAndSlider/>
          </Box>
          <Box sx={{width: '90%'}}>
            <ColorAndSlider/>
          </Box>
          <Box sx={{width: '90%'}}>
            <ColorAndSlider/>
          </Box>
          <Box sx={{width: '90%'}}>
            <ColorAndSlider/>
          </Box>
          <Box sx={{width: '90%'}}>
            <ColorAndSlider/>
          </Box>
        </Box>
        <OneCenterButton name="generate product view"/>
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
          <Button variant="contained">save for later</Button>
          <Button variant="contained">make an order</Button>
        </Stack>
        <HelperText name="please do not save more than 5 pictures"/>
      </div>
    </>
  );

}
