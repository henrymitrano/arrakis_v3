
import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { BrowserRouter as Router, Switch, Route, Redirect, Routes, UseRoutes} from "react-router-dom";

import { LoginPage } from "./LoginPage";
import { AllBonds } from './AllBonds';
import {RecentlyMaturedBonds} from './RecentlyMaturedBonds';
import {SoonToMatureBonds} from './SoonToMatureBonds';
import {BondsByIds} from './BondsByIds';
import {BondsByClient} from './BondsByClient';
import {BondsByIssuer} from './BondsByIssuer';
import { Books } from './Books';


function Routing() {
  return (
    <>
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="#home">Banking App</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="allbonds">All Bonds</Nav.Link>
            <Nav.Link href="recentlymaturedbonds">Recently matured bonds</Nav.Link>
            <Nav.Link href="soontomaturebonds">Soon to mature bonds</Nav.Link>
            <Nav.Link href="mybooks">My Books</Nav.Link>
            <Nav.Link href="bondsbyissuer">Bonds by Issuer</Nav.Link>
            <Nav.Link href="bondsbyclient">Bonds by Client</Nav.Link>
            <Nav.Link href="bondsbyids">Bonds by ISIN/CUISP</Nav.Link>
            
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>

    <Routes>
          <Route path="allbonds" element={<AllBonds/>} />
          <Route path="recentlymaturedbonds" element={<RecentlyMaturedBonds/>} />
          <Route path="soontomaturebonds" element={<SoonToMatureBonds/>} />
          <Route path="mybooks" element={<Books/>} />
          <Route path="bondsbyissuer" element={<BondsByIssuer/>} />
          <Route path="bondsbyclient" element={<BondsByClient/>} />
          <Route path="bondsbyids" element={<BondsByIds/>} />
          
    </Routes>
    </>
  );
}

export default Routing;