import React, {useState} from "react";
import {HexColorPicker} from "react-colorful";
import "../../color_picker.css";
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Slider from '@mui/material/Slider';
import {useDispatch} from "react-redux";
import {addColor, addPercentValue} from "../../store/slice/pixelSlice";

function valueLabelFormat(value) {

  const units = ['%'];

  let unitIndex = 0;
  let scaledValue = value;

  while (scaledValue >= 1024 && unitIndex < units.length - 1) {
    unitIndex += 1;
    scaledValue /= 1024;
  }

  return `${scaledValue} ${units[unitIndex]}`;
}

function calculateValue(value) {
  return value;
}

export default function ColorAndSlider({size, id}) {
  const [value, setValue] = React.useState(10);
  const [color, setColor] = useState("");
  const dispatch = useDispatch();

  const handleChange = (event, newValue) => {
    if (typeof newValue === 'number') {
      setValue(newValue);
    }
    const request = {procentage: newValue, id: id}
    dispatch(addPercentValue(request));
  };
  const onChangeColor = (color) => {
    setColor(color);
    const colorRequest = {color: color, id: id};
    dispatch(addColor(colorRequest));
  }

  return (
    <div style={{width: '100%'}}>
      <div className="App">
        <h2>Selected pixel size: {size} mm </h2>
        <div>selected color: {color}</div>
        <section className="resposive example">
          <HexColorPicker onChange={onChangeColor}/>
          {/*<HexColorPicker onChange={setColor}/>*/}
        </section>
      </div>
      <Box sx={{width: '100%'}}>
        <Typography id="non-linear-slider" gutterBottom>
          Percentage: {valueLabelFormat(calculateValue(value))}
        </Typography>
        <Slider
          value={value}
          min={0}
          step={1}
          max={100}
          scale={calculateValue}
          getAriaValueText={valueLabelFormat}
          valueLabelFormat={valueLabelFormat}
          onChange={handleChange}
          valueLabelDisplay="auto"
          aria-labelledby="non-linear-slider"
        />
      </Box>
    </div>
  );
}

