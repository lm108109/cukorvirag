// OrderItem.js
import React from 'react'
import './OrderItem.css'

const OrderItem = ({ sweetName, quantity, price, process }) => {
    return (
        <div className="order-container">
            <div className="elements">
                <h3>{sweetName}</h3>
            </div>
            <div className="elements">
                <p>Quantity: {quantity}</p>
            </div>
            <div className="elements">
                <p>Price: ${price}</p>
            </div>
            <div className="elements">
                <p>Process: {process}</p>
            </div>
        </div>
    )
}

export default OrderItem
