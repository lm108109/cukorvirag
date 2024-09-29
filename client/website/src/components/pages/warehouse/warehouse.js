import React, { useState } from "react";
import WarehouseItem from "../../data_containers/WarehouseItem/WarehouseItem";
import "./warehouse.css";

function Warehouse() {
  const [sortOrder, setSortOrder] = useState("desc");

  const sweetShopData = [
    { product: "Chocolate Bar", amount: "200 pcs" },
    { product: "Gulab Jamun", amount: "150 kg" },
    { product: "Rasgulla", amount: "120 kg" },
    { product: "Ladoo", amount: "500 pcs" },
    { product: "Jalebi", amount: "100 kg" },
    { product: "Barfi", amount: "75 kg" },
    { product: "Kaju Katli", amount: "80 kg" },
    { product: "Milk Cake", amount: "50 kg" },
    { product: "Rasgulla Tin", amount: "200 tins" },
    { product: "Sugar Syrup", amount: "500 liters" },
    { product: "Ice Cream Tub", amount: "100 tubs" },
    { product: "Candies", amount: "1000 pcs" },
    { product: "Halwa", amount: "70 kg" },
    { product: "Peda", amount: "300 pcs" },
    { product: "Mysore Pak", amount: "60 kg" },
  ];

  const sortedData = [...sweetShopData].sort((a, b) => {
    if (sortOrder === "asc") {
      return a.product.localeCompare(b.product);
    } else {
      return b.product.localeCompare(a.product);
    }
  });

  const sortRecipes = () => {
    setSortOrder(sortOrder === "asc" ? "desc" : "asc");
  };

  return (
    <div className="all-container">
      <div className="header-container">
        <div className="header-item-container">
          <div className="item">Megnevezés</div>
          <span className={`arrow ${sortOrder}`} onClick={sortRecipes}>
            {sortOrder === "desc" ? "▼" : "▲"}
          </span>
        </div>
        <div className="header-item-container">
          <div className="item">Mennyiség</div>
        </div>
      </div>
      <div className="list-container">
        {sortedData.length > 0 ? (
          <div className="recipe-list">
            {sortedData.map((item, index) => (
              <WarehouseItem
                key={index}
                product={item.product}
                amount={item.amount}
              />
            ))}
          </div>
        ) : (
          <div className="no-recipes">
            Nincsenek a keresésnek megfelelő receptek
          </div>
        )}
      </div>
    </div>
  );
}

export default Warehouse;
