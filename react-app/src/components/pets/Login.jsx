import React, { useState, useEffect } from "react";
import { findUsers } from "../../services/login-service";
import styles from "./Pets.module.css";

export const Login = () => {
    const [login, setUsers] = useState([]);
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = () => {
      //access backend and verify username correlates to password

    }
    

    useEffect(() => {
      findUsers()
            .then(({data}) => {
            setUsers(data);
            });
    }, []);
  return (
    <>
        <div>
          <h2>Login</h2>
          <form>
            <div>
              <label htmlFor="username">Username:</label>
              <input
                type="text"
                id="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                />
            </div>
            <div>
              <label htmlFor="password">Password:</label>
                <input
                  type="password"
                  id="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  />
            </div>
            <button type="button" onClick={handleLogin}>
              Login
            </button>
          </form>
        </div>
        {login.map((user) => (
          <div className={styles.pets} key={user.id}>
            <div>ID: {user.id}</div>
            <div>Username: {user.username}</div>
          </div>
        ))}
    </>
  );
};