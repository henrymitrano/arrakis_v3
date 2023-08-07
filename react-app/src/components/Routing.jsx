
import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { BrowserRouter as Router, Switch, Route, Redirect, Routes, UseRoutes} from "react-router-dom";

import { LoginPage } from "./LoginPage";
import { AllBonds } from './AllBonds';


function Routing() {
  return (
    <>
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="#home">Heroes</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#home">All Heroes</Nav.Link>
            <Nav.Link href="#link">Add Hero</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>

    <Routes>
          <Route path="allbonds" element={<AllBonds/>} />
          
    </Routes>
    </>
  );
}

export default Routing;