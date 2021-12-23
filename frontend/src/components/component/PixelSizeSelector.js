import * as React from 'react';
import Box from '@mui/material/Box';
import FormLabel from '@mui/material/FormLabel';
import FormControl from '@mui/material/FormControl';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormHelperText from '@mui/material/FormHelperText';
import Checkbox from '@mui/material/Checkbox';
import {useEffect, useState} from "react";
import {InputLabel, MenuItem, Select} from "@mui/material";
import {useDispatch, useSelector} from "react-redux";
import {addPixelSize, removePixelSize} from "../../store/slice/pixelSizeSlice";
import {getPixelSizes} from "../../api/restApi";


export default function PixelSizeSelector() {

  const [pixelSizes, setPixelSizes] = useState([]);

  useEffect(() => {
    getPixelSizes()
      .then(({data}) => setPixelSizes(data))
      .catch((error) => console.log(error));
  }, []);

  const pixelSize = useSelector(state => state.pixelSize);
  const dispatcher = useDispatch();
  const onRemovePixelSize = (id) => dispatcher(removePixelSize(id));
  const onAddPixelSizeToStore = (pixelSize) => dispatcher(addPixelSize(pixelSize));

  const [checked, setChecked] = React.useState(true);
  const handleChange = (event) => {

     setChecked(event.target.checked);
     onAddPixelSizeToStore(pixelSize);
  };


  return (
    <>
    <Box sx={{
      display: 'grid',
      gridTemplateColumns: 'repeat(3, 1fr)',
      justifyContent: 'center',
      p: 1,
      m: 1,
      bgcolor: 'background.paper'
    }}>
      <FormControl sx={{ m: 3 }} component="fieldset" variant="standard">
        <FormGroup>
          {pixelSizes.map((pixelSize)=>(
          <FormControlLabel
            pixelKey={pixelSize.id}
            control={
        <Checkbox onChange={handleChange}/>
            }
            label={pixelSize.pixelSize}
          />
          ))}
        </FormGroup>
      </FormControl>
    </Box>
    </>
  );
}






