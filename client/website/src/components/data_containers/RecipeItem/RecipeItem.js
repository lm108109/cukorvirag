import React, { useState } from 'react';
import './RecipeItem.css';

const RecipeItem = ({ title }) => {
  const [expanded, setExpanded] = useState(false);

  return (
    <div className={`recipe-item ${expanded ? 'expanded' : ''}`}>
      <div className="recipe-header">
        <div className="recipe-title">{title}</div>
        <button className="toggle-btn" onClick={() => setExpanded(!expanded)}>
          {expanded ? 'Kevesebb' : 'Megtekint'}
        </button>
      </div>
      {expanded && (
        <div className="recipe-content">
          <p>Hozzávalók:</p>
        </div>
      )}
    </div>
  );
};

export default RecipeItem;
