import * as React from 'react';
import PropTypes from 'prop-types';
import Box from '@mui/material/Box';
import ColorAndSlider from '../component/ColorAndSlider'
import {Button} from "@mui/material";
import { flexbox } from '@mui/system';
import {Image} from "@mui/icons-material";
import PixelSizeSelector from '../component/PixelSizeSelector'

function Item(props) {
  const { sx, ...other } = props;
  return (
    <Box
      sx={{
        bgcolor: 'primary.main',
        color: 'white',
        p: 1,
        m: 1,
        borderRadius: 1,
        // textAlign: 'center',
        fontSize: '1rem',
        fontWeight: '700',
        ...sx,
      }}
      {...other}
    />
  );
}

Item.propTypes = {
  sx: PropTypes.oneOfType([
    PropTypes.arrayOf(
      PropTypes.oneOfType([PropTypes.func, PropTypes.object, PropTypes.bool]),
    ),
    PropTypes.func,
    PropTypes.object,
  ]),
};

export default function FlexShrink() {
  return (
    <>

    <div style={{ width: '100%' }}>
      <Box sx={{
        display: 'flex',
        justifyContent: 'space-evenly',
        p: 1,
        m: 1,
        bgcolor: 'background.paper',
      }}>
        <Box sx={{ width: 'auto' }}>
          <PixelSizeSelector/>
        </Box>
        <Box sx={{ width: 'auto' }}>
          <PixelSizeSelector/>
        </Box>
        <Box sx={{ width: 'auto' }}>
          <PixelSizeSelector/>
        </Box>
      </Box>
    </div>

  <div style={{ width: '100%' }}>
      <Box sx={{
        display: 'flex',
        justifyContent: 'space-evenly',
        p: 1,
        m: 1,
        bgcolor: 'background.paper',
      }}>
        <Box sx={{ width: '30%' }}>
          <ColorAndSlider/>
          <ColorAndSlider/>
          <ColorAndSlider/>
        </Box>
        <Box sx={{ width: '70%' }}>
          <Item sx={{ height:400 }}>what oi this</Item>
        </Box>
      </Box>
    </div>
    </>
  );

}
