import * as React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import GlobalStyles from '@mui/material/GlobalStyles';
import {Route, Routes} from "react-router-dom";
import UserRegistration from "../forms/UserRegistration";
import PictureGeneration from "../../page/PictureGeneration";
import CreateOrder from "../forms/CreateOrder";
import Login from "../forms/Login";

export default () => {
  return (
    <>
      <GlobalStyles styles={{ ul: { margin: 0, padding: 0, listStyle: 'none' } }} />
      <CssBaseline />
      <Routes>
        <Route path="/users/registration" element={<UserRegistration/>}/>
        <Route path="/generate_picture" element={<PictureGeneration/>}/>
        <Route path="/order" element={<CreateOrder/>}/>
        <Route path="/login" element={<Login/>}/>
      </Routes>
    </>
  )
}