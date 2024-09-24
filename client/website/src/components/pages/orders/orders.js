import React from 'react';
import './orders.css';

function Orders() {
  return (
    <div className='orders-container'>
      <div className='header-for-children'>
        <div className='header-item'>Feldolgozásra vár</div>
        <div className='header-item'>Készül</div>
        <div className='header-item'>Elkészült</div>
      </div>
      <div className='content-container'>
        <div className='processing-container'></div>
        <div className='about-container'></div>
        <div className='ready-container'></div>
      </div>
      <div>
        <button className="floating-button">+</button>
      </div>
    </div>
  );
}

export default Orders;
