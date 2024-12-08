import React from 'react'

const WarehouseItem = ({ product, amount, unit }) => {
    return (
        <div className="flex justify-between items-center border border-gray-300 p-2 mb-2 rounded-lg shadow-sm bg-white hover:shadow-md transition-shadow">
            {/* Product Name */}
            <div className="text-left">
                <span className="font-medium text-sm text-gray-800">
                    {product || 'Unknown Product'}
                </span>
            </div>
            {/* Amount with Unit */}
            <div className="text-right">
                <span className="text-gray-600 text-sm">
                    {amount || '0'} {unit || ''}
                </span>
            </div>
        </div>
    )
}

export default WarehouseItem
