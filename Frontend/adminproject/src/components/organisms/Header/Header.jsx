import "./Header.css";
import Button from "../../atoms/Button/Button";

function Header(props) {
  const { onChangeEmployee, onChangeVendor, onChangeCreate, onChangeEmail, disableEmailbtn, tabHeader } = props;
  return (
    <div className="header">
      <div className="navbtn">
        <Button name={"employee"} variant={tabHeader === "Employee" && "contained"} label={"Employee"} onClick={onChangeEmployee} />
        <Button name={"vendor"} variant={tabHeader === "Vendor" && "contained"} label={"Vendor"} onClick={onChangeVendor} />
      </div>
      <div>
        {tabHeader === "Vendor" ? <Button name={"Email"} variant="contained" label={"Send Email"} onClick={onChangeEmail} disabled={disableEmailbtn} /> : ""}
       
          <Button name={tabHeader} variant="contained" label={`Create ${tabHeader}`} onClick={onChangeCreate} />

        
      </div>
    </div>
  );
}

export default Header;