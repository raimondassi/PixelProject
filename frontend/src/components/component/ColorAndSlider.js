import React from "react";
import { HexColorPicker, RgbaColorPicker } from "react-colorful";
import "../../color_picker.css";
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Slider from '@mui/material/Slider';

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

export default function NonLinearSlider() {
  const [value, setValue] = React.useState(10);

  const handleChange = (event, newValue) => {
    if (typeof newValue === 'number') {
      setValue(newValue);
    }
  };
  return (
    <div style={{ width: '100%' }}>
    <div className="App">
      <h2>Select Color</h2>
      <section className="resposive example">
        <HexColorPicker/>
      </section>
    </div>
  <Box sx={{ width: '100%' }}>
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

