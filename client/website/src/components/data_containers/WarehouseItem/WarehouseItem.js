import React from "react";
import "./WarehouseItem.css";

const WarehouseItem = ({ product, amount }) => {
  return (
    <div className="warehouse-container">
      <div className="warehouse-item">{product}</div>
      <div className="warehouse-item">{amount}</div>
    </div>
  );
};

export default WarehouseItem;
