import React ,{Suspense} from "react";
import logo from './logo.svg';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import MetaFile from "./components/pages/MetaFile/MetaFile";
import './App.css';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Suspense fallback ={()=> <div>...loading</div>}>
          <Routes>
            <Route path="/" element={<MetaFile/>}/>
          </Routes>
        </Suspense>
      </BrowserRouter>
    </div>
  );
}

export default App;