import * as React from 'react';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';

export default function OneCenterButton({name}) {
  return (
    <Stack spacing={2} direction="row" justifyContent="center" >
      <Button variant="contained">{name}</Button>
    </Stack>
  );
}
