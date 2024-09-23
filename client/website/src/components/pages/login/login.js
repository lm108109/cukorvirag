import React, { useEffect } from 'react';
import { useAuth } from '../../utils/AuthContext/AuthContext';
import { useNavigate } from 'react-router-dom';
import './login.css';

function LogIn({}) {
  const navigate = useNavigate();
  const { user } = useAuth();

  useEffect(() => {
    if (user) {
      navigate('/home');
    }
  }, []);

  return (
    <div className="login-container">
      <div className="login-box">
        <h2>Bejelentkezés</h2>
        <form>
          <input type="text" placeholder="Felhasználónév" />
          <input type="password" placeholder="Jelszó" />
          <button type="submit">Mehet</button>
        </form>
      </div>
    </div>
  );
}

export default LogIn;
