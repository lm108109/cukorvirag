import React from 'react'
import NavRoutes from '../utils/navroutes/navroutes'

function MainContent() {
    return (
        <div className="flex-grow mt-[160px] md:mt-[120px] flex flex-col main-bg overflow-y-auto">
            <NavRoutes />
        </div>
    )
}

export default MainContent
