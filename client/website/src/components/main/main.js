import React from 'react'
import NavRoutes from '../utils/navroutes/navroutes'

function MainContent() {
    return (
        <div className="flex-grow mt-[160px] md:mt-[130px] flex flex-col bg-[#f9f5f2] overflow-y-auto">
            <NavRoutes />
        </div>
    )
}

export default MainContent
