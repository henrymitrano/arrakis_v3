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
    
      
       

          {bonds.map(bond=>(
           <BondDetail info={bond} key={bond.id.toString()} />
          ))}

          </> 
    
    )
}
