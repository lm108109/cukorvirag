import React from 'react';

function LogOut({ handleLogout }) {
  return (
    <div>
      <h2>Are you sure you want to log out?</h2>
      <button onClick={handleLogout}>Log Out</button>
    </div>
  );
}

export default LogOut;
