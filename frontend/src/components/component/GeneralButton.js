import * as React from 'react';
import Button from '@mui/material/Button';

export default function GeneralButton({name}) {
  return (
      <Button variant="contained" style={{margin:2}} >{name}</Button>
  );
}
