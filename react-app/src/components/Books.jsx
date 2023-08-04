import { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import Table from 'react-bootstrap/Table';
import { findBooks } from "../services/book-display";

// Create Array of bonds
export const Books = () => {
       // const [bonds, setBonds] = useState([]);
        

        return (
          <Table striped bordered hover>
            <thead>
              <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {d.map((book) => (
                <tr key = {index}>



                </tr>
              ) 
              
              )}
            </tbody>
          </Table>
        );
      
}

