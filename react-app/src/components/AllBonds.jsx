import React from 'react'
import BondDetail from './BondDetail'
import { getAllBonds } from '../services/bond-service';
import { useState } from 'react';
import { useEffect } from 'react';


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
