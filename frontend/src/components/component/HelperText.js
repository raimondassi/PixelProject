import * as React from "react";
import FormHelperText from "@mui/material/FormHelperText";


export default function HelperText({name}) {
  return(
  <FormHelperText style={{textAlign: "center"}}>
    {name}
  </FormHelperText>
  )
}