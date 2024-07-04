import React, { useState, useEffect } from 'react';
import Header from "../../organisms/Header/Header";
import CommonDataGrid from '../../atoms/DataGrid/CommonDataGrid';
import { fetchData, sendData } from "../../../services/axios"
import CreateModal from '../../organisms/Model/CreateModal';
import { TextField, Typography } from '@mui/material';

function MetaFile() {
  const employeeColumns = [
    { field: 'name', headerName: 'Name', width: 200 },
    { field: 'designation', headerName: 'Designation', width: 130 },
    {
      field: 'ctc',
      headerName: 'CTC',
      type: 'number',
      width: 130,
    },
    { field: 'email', headerName: 'Email', width: 200 },
  ];

  const vendorColumns = [
    { field: 'name', headerName: 'Name', width: 200 },
    { field: 'email', headerName: 'Email', width: 200 },
    { field: 'upi', headerName: 'UPI', width: 200 },
  ];

  const vendorEmailColumns = [
    { field: 'email', headerName: 'Email', width: 200 },
    { field: 'subject', headerName: 'Subject', width: 200 },
    { field: 'content', headerName: 'Body', width: 600 },
  ];

  const createEmployeeModalInputs = [
    { name: 'name', label: 'Name' },
    { name: 'email', label: 'Email' },
    { name: 'designation', label: 'Designation' },
    { name: 'ctc', label: 'CTC' }
  ]

  const createVendorModalInputs = [
    { name: 'name', label: 'Name' },
    { name: 'email', label: 'Email' },
    { name: 'upi', label: 'UPI' }
  ]

  const [columnHeader, setColumnHeader] = useState(employeeColumns);
  const [rowData, setRowData] = useState([]);
  const [tabHeader, setTabHeader] = useState("Employee");
  const [selectedRows, setSelectedRows] = useState([]);
  const [emailData, setEmailData] = useState([]);
  const [open, setOpen] = useState(false);
  const [userData, setUserData] = useState({});

  const onChangeEmployee = (e) => {
    setColumnHeader(employeeColumns);
    fetchUserData("view-employees", "employeeDetails", setRowData)
    setTabHeader("Employee");
  }

  const onChangeVendor = (e) => {
    setColumnHeader(vendorColumns);
    fetchUserData("view-vendors?isEmailData=false", "vendorDetailResponse", setRowData)
    fetchUserData("view-vendors?isEmailData=true", "vendorEmailResponse", setEmailData)
    setTabHeader("Vendor")
  }

  const formatEmailColumns = () => {

    return emailData?.map(emailObj => ({
      ...emailObj,
      "email": emailObj?.recipient?.email
    }));

  }

  const onClickCreate = () => {

    setOpen(true)

  }


  const onRowSelectionModelChange = (selectedDataGridRows) => {
    setSelectedRows(selectedDataGridRows);
  };

  const onClickSendEmail = async () => {
    let sendEmails = rowData?.filter(row => selectedRows.includes(row?.id)).map(selectedRow => ({
      "to": selectedRow?.email,
      "subject": "Payment",
      "body": `Sending payments to vendor ${selectedRow?.name} at upi ${selectedRow?.upi}`
    }));
    setSelectedRows([]);
    await sendData("send-email", { "emailRequest": sendEmails });
    await fetchUserData("view-vendors?isEmailData=true", "vendorEmailResponse", setEmailData)
  }


  useEffect(() => {
    fetchUserData("view-employees", "employeeDetails", setRowData)
  }, [])

  const fetchUserData = async (url, key, setData) => {
    try {
      const result = await fetchData(url);
      console.log(result, "result")
      setData(result[key] || []);
    } catch (error) {
      // Handle error
      console.error('Error fetching data:', error);
    }
  };

  const onSubmit = () => {

    if (tabHeader === "Vendor") {
      sendUserData("create-vendor");
    } else {
      sendUserData("create-employee");
    }

  }

  const handleClose = () => {
    setOpen(!open)
    setUserData({})
  };

  const sendUserData = async (url) => {
    console.log(userData, url);
    await sendData(url, userData);
    handleClose();
    if (tabHeader === "Vendor") {
      await fetchUserData("view-vendors?isEmailData=false", "vendorDetailResponse", setRowData)
    } else {
      await fetchUserData("view-employees", "employeeDetails", setRowData)
    }
  }

  const onChangeInputs = e => {
    const { name, value } = e.target;
    setUserData({
      ...userData,
      [name]: value
    })
  }

  return (
    <div>
      <Header
        onChangeEmployee={onChangeEmployee}
        onChangeVendor={onChangeVendor}
        onChangeCreate={onClickCreate}
        onChangeEmail={onClickSendEmail}
        disableEmailbtn={selectedRows?.length < 1}
        tabHeader={tabHeader}
      />
      <CommonDataGrid
        columns={columnHeader}
        rows={rowData}
        checkboxSelection={tabHeader === "Vendor"}
        onRowSelectionModelChange={onRowSelectionModelChange}
        selectedRows={tabHeader === "Vendor" ? selectedRows : []}
      />

      {
        tabHeader === "Vendor" &&
        <div style={{ marginTop: "20px" }}>
          <Typography variant='h5' marginBottom='20px'>Email Data</Typography>

          <CommonDataGrid
            columns={vendorEmailColumns}
            rows={formatEmailColumns()}
            checkboxSelection={false}
          />
        </div>

      }


      <CreateModal
        open={open}
        inputs={tabHeader === "Vendor" ? createVendorModalInputs : createEmployeeModalInputs}
        createLabel={tabHeader === "Vendor" ? "Create Vendor" : "Create Employee"}
        onClickCreate={onSubmit}
        onChangeInputs={onChangeInputs}
        handleClose={handleClose}
        createButtonDisabled={Object.keys(userData).length != (tabHeader === "Vendor" ? 3 : 4)}
      />
    </div>
  )
}

export default MetaFile