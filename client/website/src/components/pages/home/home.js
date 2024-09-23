import React, { useState, useEffect } from 'react';
import './home.css';

const Home = () => {
  const [time, setTime] = useState('');
  const [date, setDate] = useState('');

  useEffect(() => {
    const updateTimeAndDate = () => {
      const now = new Date();
      const hours = String(now.getHours()).padStart(2, '0');
      const minutes = String(now.getMinutes()).padStart(2, '0');
      const day = String(now.getDate()).padStart(2, '0');
      let month = now.toLocaleString('hu-HU', { month: 'long' });
      month = month.charAt(0).toUpperCase() + month.slice(1);
      const year = now.getFullYear();

      setTime(`${hours}:${minutes}`);
      setDate(`${year}. ${month} ${day}.`);
    };

    // Initial call to set the time and date right away
    updateTimeAndDate();

    // Update the time every second
    const intervalId = setInterval(updateTimeAndDate, 1000);

    // Clean up the interval on component unmount
    return () => clearInterval(intervalId);
  }, []);

  return (
    <div className="home-container">
      <div className="time-container">
        <h1>{time}</h1>
        <p>{date}</p>
      </div>
      <div className="quote-container">
        <p>“Édes pillanatok, melyek virágba borítják a napodat!”</p>
      </div>
      <button className="plus-button">+</button>
    </div>
  );
};

export default Home;
