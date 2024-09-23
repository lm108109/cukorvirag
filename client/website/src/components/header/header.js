import React from 'react';
import { NavLink } from 'react-router-dom';
import './header.css';
import { useAuth } from '../utils/AuthContext/AuthContext';

function Header() {
  const { user } = useAuth();
  return (
    <div className="Header-container">
      <header className="Header">
        <div className="FirstNav">
          <nav className="Navbar">
            {user ? (
              <ul className="ListElement">
                <li className="Routerbutton">
                  <NavLink to="/home" activeClassName="active">
                    Home
                  </NavLink>
                </li>
                <li className="Routerbutton">
                  <NavLink to="/warehouse" activeClassName="active">
                    Raktár
                  </NavLink>
                </li>
                <li className="Routerbutton">
                  <NavLink to="/orders" activeClassName="active">
                    Rendelések
                  </NavLink>
                </li>
                <li className="Routerbutton">
                  <NavLink to="/recipes" activeClassName="active">
                    Receptek
                  </NavLink>
                </li>
                <li className="Routerbutton">
                  <NavLink to="/contact" activeClassName="active">
                    Kapcsolat
                  </NavLink>
                </li>
              </ul>
            ) : null}
          </nav>
        </div>
        <div className="Image-container">
          <img
            src={`${process.env.PUBLIC_URL}/sugar_flower.png`}
            alt="Sugar Flower"
            className="HeaderImage"
          />
        </div>
        <div className="SecondNav">
          <nav className="Navbar">
            {user ? (
              <ul className="ListElement">
                <li className="Routerbutton">
                  <NavLink to="/logout" activeClassName="active">
                    Kijelentkezés
                  </NavLink>
                </li>
              </ul>
            ) : null}
          </nav>
        </div>
      </header>
    </div>
  );
}

export default Header;
