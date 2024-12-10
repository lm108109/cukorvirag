import React, { useState } from 'react'

const RecipeItem = ({ title, description }) => {
    const [expanded, setExpanded] = useState(false)

    return (
        <div
            className="border-2 border-black rounded-xl p-4 mb-4 transition-all duration-300 bg-custom-pink"
        >
            <div className="flex justify-between items-center">
                <div className="text-lg font-bold">{title}</div>
                <button
                    className="toggle-btn bg-transparent border-2 border-black rounded-lg px-3 py-1 text-sm cursor-pointer hover:bg-custom-pink transition-colors"
                    onClick={() => setExpanded(!expanded)}
                >
                    {expanded ? 'Kevesebb' : 'Megtekint'}
                </button>
            </div>
            {expanded && (
                <div
                    className="recipe-content mt-5 p-4 border border-black h-40 overflow-y-auto"
                    style={{ wordWrap: 'break-word', whiteSpace: 'pre-wrap' }}
                >
                    <p className="font-bold">Hozzávalók:</p>
                    <p>{description}</p>
                </div>
            )}
        </div>
    )
}

export default RecipeItem
