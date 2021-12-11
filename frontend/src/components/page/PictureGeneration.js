import * as React from 'react';
import PropTypes from 'prop-types';
import Box from '@mui/material/Box';
import ColorAndSlider from '../component/ColorAndSlider'

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
        textAlign: 'center',
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
    <div style={{ width: '100%' }}>
      <Box sx={{ display: 'flex', p: 1, bgcolor: 'background.paper' }}>
        <ColorAndSlider sx={{flexShrink: 1}}/>
        <Item sx={{ width: '70%' }}>Picture will generate</Item>
      </Box>
      <Box sx={{ display: 'flex', p: 1, bgcolor: 'background.paper' }}>
        <ColorAndSlider sx={{flexShrink: 1}}/>
      </Box>
      <Box sx={{ display: 'flex', p: 1, bgcolor: 'background.paper' }}>
        <Item sx={{ width: '70%' }}>Picture will generate</Item>
      </Box>
    </div>
  );
}
