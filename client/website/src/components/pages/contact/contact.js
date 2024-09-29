// src/pages/Home.js
import React from 'react';
import './contact.css';

function Contact() {
  return (
    <div className="contact-container">
      <div className="store-section">
        <h2>Cukorvirág Cukrászda</h2>
        <h3>Központi üzlet:</h3>
        <p>Cím: 1234 Debrecen, Édes utca 5.</p>
        <p>Telefon: +36 1 234 5678</p>
        <p>Email: cukorvirag@cukorvirag.hu</p>
        <p>Kapcsolattartó: Kovács Anna (üzletvez.)</p>
        <p>Nyitvatartás: Hét. - Vas.: 9:00 - 19:00</p>
      </div>

      <div className="branch-section">
        <h3>Fióküzlet:</h3>
        <p>Cím: 4321 Budapest, Sütike tér 10.</p>
        <p>Telefon: +36 1 876 5432</p>
        <p>Email: sutiketer@cukorvirag.hu</p>
        <p>Kapcsolattartó:Szabó Péter (üzletvez.)</p>
        <p>Nyitvatartás: Hét. - Szom.: 10:00 - 18:00</p>
      </div>

      <div className="management-section">
        <h3>Vezetés:</h3>
        <p>Tulajdonos: Nagy Erika</p>
        <p>Telefon: +36 30 123 4567</p>
        <p>Email: nagy.erika@cukorvirag.hu</p>
      </div>
    </div>
  );
}

export default Contact;
