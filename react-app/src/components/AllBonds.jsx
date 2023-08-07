import React from 'react'
import BondDetail from './BondDetail'
import { getAllBonds } from '../services/bond-service';
import { useState } from 'react';
import { useEffect } from 'react';
import Routing from './Routing';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { BrowserRouter as Router, Switch, Route, Redirect, Routes, UseRoutes} from "react-router-dom";



export const AllBonds = () => {
    const [bonds,setBonds] = useState([]);
    useEffect(()=>{
        getAllBondsFromAPI();}, 
        []
    );


    const getAllBondsFromAPI = () => {
            getAllBonds()
        .then(res => {
            setBonds(res.data);
        })
        .catch(err => {
            setBonds([]);
            console.log(err);
        })

    }


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

          {bonds.map(bond=>(
           <BondDetail info={bond} key={bond.id.toString()} />
          ))}

          </> 
    
    )
}
