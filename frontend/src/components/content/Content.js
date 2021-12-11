import * as React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import GlobalStyles from '@mui/material/GlobalStyles';
import Product from "../forms/Product";
import UserRegistration from "../forms/UserRegistration";
import {Routes} from "react-router-dom";
import Products from "../page/Products";
import {Route} from "@mui/icons-material";

export default () => {
  return (
    <>
      <GlobalStyles styles={{ ul: { margin: 0, padding: 0, listStyle: 'none' } }} />
      <CssBaseline />
      <Routes>
        <Route path="/" element={<Products/>} />
        <Route path="/products/create" element={<Product/>}  />
      </Routes>
      <Product/>
      <UserRegistration/>
    </>
  )
}