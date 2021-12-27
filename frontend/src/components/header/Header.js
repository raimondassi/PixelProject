import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";
import Button from "@mui/material/Button";
import AppBar from "@mui/material/AppBar";
import * as React from "react";
import {NavLink} from "react-router-dom";

export default () => {
  return (
    <AppBar
      position="static"
      color="default"
      elevation={0}
      sx={{ borderBottom: (theme) => `1px solid ${theme.palette.divider}` }}
    >
      <Toolbar sx={{ flexWrap: 'wrap' }}>
        <Typography variant="h6" color="inherit" noWrap sx={{ flexGrow: 1 }}>
          <Link
            variant="button"
            color="text.primary"
            to="/products/generate_picture"
            sx={{my: 1, mx: 1.5, fontSize: 20}}
            underline="none"
            component={NavLink}>
            PixelGen
          </Link>
        </Typography>
        <nav>
          <Link
            variant="button"
            color="text.primary"
            to="/users/registration"
            sx={{ my: 1, mx: 1.5 }}
            component={NavLink}>
            Create new user
          </Link>
        </nav>
        <Button href="#" variant="outlined" sx={{ my: 1, mx: 1.5 }}>
          Login
        </Button>
      </Toolbar>
    </AppBar>
  )
}