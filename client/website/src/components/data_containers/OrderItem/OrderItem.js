// OrderItem.js
import React from 'react'

const OrderItem = ({ sweetName, quantity, price, process }) => {
    return (
        <div className="bg-orders-item rounded-lg p-4 mb-4">
            <div className="mb-1">
                <h3 className="text-lg font-bold">{sweetName}</h3>
            </div>
            <div className="mb-1">
                <p>Quantity: {quantity}</p>
            </div>
            <div className="mb-1">
                <p>Price: ${price}</p>
            </div>
            <div>
                <p>Process: {process}</p>
            </div>
        </div>
    )
}

export default OrderItem
