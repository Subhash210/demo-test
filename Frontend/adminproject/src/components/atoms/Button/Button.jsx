import React from 'react'
import { Button as MuiButton } from '@mui/material';

function Button(props) {
    const{label, variant, onClick, name, disabled=false} = props;
  return (

    <MuiButton
      variant={variant}
      onClick={onClick}
      name = {name}
      className={`button-${label}`}
      disabled={disabled}
      color={props.color}
      style={{margin : "5px"}}
    >{label}</MuiButton> 
    
  )
}

export default Button