// OrderItem.js
import React from 'react'

const OrderItem = ({
    sweetName,
    quantity,
    price,
    process,
    name,
    phone_number,
}) => {
    return (
        <div className="bg-orders-item rounded-lg p-4 mb-4">
            <div className="mb-1">
                <h3 className="text-lg font-bold">{sweetName}</h3>
            </div>
            <div className="mb-1">
                <p>Ügyfél: {name + ' ' + phone_number}</p>
            </div>
            <div className="mb-1">
                <p>Mennyiség: {quantity}</p>
            </div>
            <div className="mb-1">
                <p>Ár: {price} Ft</p>
            </div>
            <div>
                <p>Folyamat: {process}</p>
            </div>
        </div>
    )
}

export default OrderItem
