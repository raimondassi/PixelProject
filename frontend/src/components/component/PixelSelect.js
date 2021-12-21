import * as React from 'react';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import {useEffect, useState} from "react";
import {getPixelSizes} from "../../api/restApi";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";


export default function PixelSelect() {
  const [pixel, setPixel] = React.useState('');

  const [pixelSizes, setPixelSizes] = useState([]);
  useEffect(() => {
    getPixelSizes()
      .then(({data}) => setPixelSizes(data))
      .catch((error) => console.log(error));
  }, []);

  const handleChange = (event) => {
    setPixel(event.target.value);
  };

  return (
    <Box sx={{ minWidth: 120 }}>
      <FormControl fullWidth>
        <InputLabel id="demo-simple-select-label">pixel size in mm</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={pixel}
          label="Pixel size in mm"
          onChange={handleChange}
        >
          {pixelSizes.map((pixelSize)=>(
              // key={pixelSize.id}
                <MenuItem value={pixelSize.pixelSize}>{pixelSize.pixelSize}</MenuItem>
            ))}
        </Select>
      </FormControl>
    </Box>
  );
}
