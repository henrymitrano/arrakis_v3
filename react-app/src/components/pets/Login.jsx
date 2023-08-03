import React, { useState, useEffect } from "react";
import { findUsers } from "../../services/login-service";
import styles from "./Pets.module.css";

export const Login = () => {
    const [login, setUsers] = useState([]);

    useEffect(() => {
      findUsers()
            .then(({data}) => {
            setUsers(data);
            });
    }, []);
  return (
    <>
        { login.map(user => 
        <div className={styles.pets}>
            <div>ID: {user.id}</div>
            <div>Userame: {user.username} </div>
            <div>Password: {user.password}</div>
        </div>) 
        }
    </>
  )
};