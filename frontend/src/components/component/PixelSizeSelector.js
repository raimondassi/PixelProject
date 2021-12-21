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


export default function CheckboxesGroup() {

  const [pixelSizes, setPixelSizes] = useState([]);
  useEffect(() => {
    getPixelSizes()
      .then(({data}) => setPixelSizes(data))
      .catch((error) => console.log(error));
  }, []);

  const getPikselSizesfromHook=()=>{
    return pixelSizes;
  }

  const [checkBoxState, setCheckBoxState] = React.useState({
  });
  const pixelSize = useSelector(state => state.pixelSize);
  const dispatcher = useDispatch();
  const onRemovePixelSize = (id) => dispatcher(removePixelSize(id));
  const onAddPixelSizeToStore = (pixelSize) => dispatcher(addPixelSize(pixelSize));

  const handleChange = (event, pixelSize) => {
     //  if(checkBoxState===checked) {onAddPixelSizeToStore(pixelSize)};
  };

  return (
    <>
    <Box sx={{ display: 'flex' }}>
      <FormControl sx={{ m: 3 }} component="fieldset" variant="standard">
        {/*<FormLabel component="legend">Select pixel size</FormLabel>*/}
        <FormGroup>
          {pixelSizes.map((pixelSize)=>(
          <FormControlLabel
            key={pixelSize.id}
            control={
               <Checkbox onChange={handleChange(pixelSize)}/>
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
export {CheckboxesGroup}