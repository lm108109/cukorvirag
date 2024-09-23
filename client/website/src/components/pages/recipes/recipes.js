import React, { useState, useEffect } from 'react';
import RecipeItem from '../../data_containers/RecipeItem/RecipeItem';
import './recipes.css'; // Import the CSS file

const Recipes = () => {
  const [inputText, setInputText] = useState('');
  let inputHandler = (e) => {
    //convert input text to lower case
    var lowerCase = e.target.value.toLowerCase();
    setInputText(lowerCase);
  };
  const [sortOrder, setSortOrder] = useState('desc');

  let [recipes, setRecipes] = useState([
    'Málna torta',
    'Francia Krémes',
    'Dobos torta',
    'Torta',
  ]);

  recipes = recipes.filter((filter_text) => {
    if (inputText === '') {
      return filter_text;
    } else {
      return filter_text.toLowerCase().includes(inputText);
    }
  });

  const sortRecipes = () => {
    const sortedRecipes = [...recipes].sort((a, b) => {
      if (sortOrder === 'desc') {
        return a.localeCompare(b);
      } else {
        return b.localeCompare(a);
      }
    });
    setRecipes(sortedRecipes);
    setSortOrder(sortOrder === 'asc' ? 'desc' : 'asc');
  };

  useEffect(() => {
    sortRecipes();
  }, []);

  return (
    <>
      <div className="search-header-container">
        <input
          input={inputText}
          type="text"
          placeholder="Keresés"
          className="search-input"
          onChange={inputHandler}
        />
        <div className="recipes-and-sort">
          <h2 className="list-title">Receptek</h2>
          <span className={`sort-arrow ${sortOrder}`} onClick={sortRecipes}>
            {sortOrder === 'desc' ? '▼' : '▲'}
          </span>
        </div>
      </div>
      <div className="recipe-list-container">
        {recipes.length >= 1 ? (
          <div className="recipe-list">
            {recipes.map((recipe, index) => (
              <RecipeItem key={index} title={recipe} />
            ))}
          </div>
        ) : (
          <div className="no-recipes">
            Nincsenek a keresésnek megfelelő receptek
          </div>
        )}
      </div>
    </>
  );
};

export default Recipes;
