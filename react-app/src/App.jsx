import "./App.css"
import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import { Pets } from "./components/pets/Pets";
import { LoginPage } from "./components/LoginPage";
import { Books } from "./components/Books";
import { AllBonds } from './components/AllBonds';




const App = () => {
  return (
    <div><AllBonds/></div>
  )
};

export default App;
