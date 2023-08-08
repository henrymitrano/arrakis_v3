import React from 'react'
import BondDetail from './BondDetail'
import { getAllBonds } from '../services/bond-service';
import { useState } from 'react';
import { useEffect } from 'react';
import {Text} from 'react-native';


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
        <table>
            <tr>
                <th>Bond ID  </th>
                <th>Quantity  </th>
                <th>Bond ISIN  </th>
                <th>Bond CUSIP</th>
            </tr>
            {bonds.map(bond=>(
                <BondDetail info={bond} key={bond.id.toString()} />
            ))}
          </table>

          </> 
    
    )
}
