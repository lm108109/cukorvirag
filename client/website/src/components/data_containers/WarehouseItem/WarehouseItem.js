import React from 'react'

const WarehouseItem = ({ product, amount, unit }) => {
    return (
        <div className="flex justify-between border-2 border-black rounded-xl mb-4 p-2 transition-all duration-300 bg-custom-pink">
            {/* Product Name */}
            <div className="text-left">
                <span className="text-lg font-bold">
                    {product || 'Unknown Product'}
                </span>
            </div>
            {/* Amount with Unit */}
            <div className="text-right">
                <span className="text-lg font-bold">
                    {amount || '0'} {unit || ''}
                </span>
            </div>
        </div>
    )
}

export default WarehouseItem
