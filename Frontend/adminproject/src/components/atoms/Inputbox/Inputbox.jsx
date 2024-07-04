import React from 'react'

function Inputbox(props) {
    const{
        name,
        id,
        labelName,
        required,
        value,
        ...rest
    } = props;
  return (
    <div className="inputBox-root">
        <label for={id}>{labelName}</label>
        <input name ={name} value={value} id ={id} className={`input-${name} inputbox-class`} {...rest}/>
    </div>
  )
}

export default Inputbox