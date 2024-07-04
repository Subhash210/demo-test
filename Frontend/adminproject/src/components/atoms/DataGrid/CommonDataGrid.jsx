import React from 'react';
import { DataGrid } from '@mui/x-data-grid';

function CommonDataGrid(props) {
  const {columns, rows, checkboxSelection,onRowSelectionModelChange,selectedRows } = props

  return (
    <div style={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={rows}
        columns={columns}
        initialState={{
          pagination: {
            paginationModel: { page: 0, pageSize: 5 },
          },
        }}
        pageSizeOptions={[5, 10]}
        checkboxSelection= {checkboxSelection}
        onRowSelectionModelChange={checkboxSelection && onRowSelectionModelChange}
        rowSelectionModel= {selectedRows}
        rowSelection = {checkboxSelection}
      />
    </div>
  );
}

export default CommonDataGrid