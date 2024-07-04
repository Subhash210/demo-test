import React, { useState } from 'react';
import Box from '@mui/material/Box';
import Button from "../../atoms/Button/Button";
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { TextField } from '@mui/material';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

function CreateModal(props) {

  const { open, inputs, createLabel, onClickCreate, onChangeInputs, handleClose, createButtonDisabled} = props

 

  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >

        <Box sx={style}>

          <Typography variant='h5'>{createLabel}</Typography>

          {inputs.map(input => {
            return (
              <div key = {input?.name} style={{ marginTop: "15px" }}>
                <TextField id="outlined-basic" name={input?.name} label={input?.label} variant="outlined" onChange={onChangeInputs}/>
              </div>)
          })}

          <div style={{ marginTop: "15px", display: "flex", justifyContent: "space-between", padding: "0px 0px 0px 220px" }}>
            <Button name={"cancel"} variant='outlined' color='error' label={"Cancel"} onClick={handleClose} />
            <Button name={"create"} variant='contained' color='success' label={"Create"} disabled={createButtonDisabled} onClick={onClickCreate} />
          </div>


        </Box>
      </Modal>
    </div>
  );
}

export default CreateModal;