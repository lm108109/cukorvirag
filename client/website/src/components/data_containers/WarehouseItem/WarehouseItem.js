import React from 'react'

const WarehouseItem = ({ product, amount }) => {
    return (
        <div className="flex justify-between items-center border p-4 m-4 rounded-lg shadow-md bg-white">
            <div className="text-left m-2">
                <span className="font-semibold text-lg">{product}</span>
            </div>
            <div className="text-right m-2">
                <span className="text-gray-700">{amount} pcs</span>
            </div>
        </div>
    )
}

export default WarehouseItem
