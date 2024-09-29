import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from '../../pages/home/home';
import Warehouse from '../../pages/warehouse/warehouse';
import Orders from '../../pages/orders/orders';
import Contact from '../../pages/contact/contact';
import LogOut from '../../pages/log_out/log_out';
import Recipes from '../../pages/recipes/recipes';
import LogIn from '../../pages/login/login';
import PrivateRoutes from '../privateRoutes/PrivateRoutes';

function NavRoutes() {
  return (
    <Routes>
      {/* Public route for login */}
      <Route path="/" element={<LogIn />} />
      <Route path="/login" element={<LogIn />} />

      {/* Private routes: accessible only when authenticated */}
      <Route element={<PrivateRoutes />}>
        <Route path="/home" element={<Home />} />
        <Route path="/warehouse" element={<Warehouse />} />
        <Route path="/orders" element={<Orders />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/recipes" element={<Recipes />} />
        <Route path="/logout" element={<LogOut />} />
      </Route>
    </Routes>
  );
}

export default NavRoutes;
