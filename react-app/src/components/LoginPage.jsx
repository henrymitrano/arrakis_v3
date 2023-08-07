import { useState, useEffect } from 'react';
import { findUsers } from "../services/login-service";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';

import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';



import { BrowserRouter as Router, Switch, Route, Redirect, Routes, UseRoutes} from "react-router-dom";




export const LoginPage = (props) => {  
  const [show, setShow] = useState(false);
  const [login, setUsers] = useState([]);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleClose = () => {
    setShow(false);
    setUsername("");
    setPassword("");
  } 
  const handleShow = () => setShow(true);

  const navigate = useNavigate();
  const handleLogin = () => {
    if (!username || !password){
      alert("Username or Password is blank");
      return;
    }

    const user = login.find((user) => user.username = username);

    if (user) {

      if(user.password == password){
        alert("login successful!");
        props.setStatus(true);
        navigate("/AllBonds");
        
      } else {
        alert("username or password incorrect");
      }
    } else {
      alert("username not found");
    }
    handleClose();
  }

  useEffect(() => {
    findUsers()
          .then(({data}) => {
          setUsers(data);
          });
  }, []);

  return (
    <>
      <Button variant="primary" onClick={handleShow}>
        Login
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Login</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
              <Form.Label>Username</Form.Label>
              <Form.Control
                type="text"
                placeholder="username"
                autoFocus
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </Form.Group>
            <Form.Group
              className="mb-3"
              controlId="exampleForm.ControlTextarea1"
            >
              <Form.Label>Password</Form.Label>
              <Form.Control 
                type = "password" 
                placeholder="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleLogin}>
            Submit
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );

  
}


