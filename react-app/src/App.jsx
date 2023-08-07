import "./App.css"
import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import { Pets } from "./components/pets/Pets";
import { LoginPage } from "./components/LoginPage";
import { Books } from "./components/Books";
import { AllBonds } from './components/AllBonds';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from "react-router-dom";
import { BrowserRouter as Router, Switch, Route, Redirect, Routes, UseRoutes} from "react-router-dom";
import Routing from "./components/Routing";
import { useState } from "react";
import Home from "./components/Home";

const App = () => {
  const [appStatus, setAppStatus] = useState(false);

  return(
    <>
    {!appStatus ? <LoginPage setStatus={setAppStatus}/>
  
      : <Home/>
        }
        
        </>

  )
};

export default App;
