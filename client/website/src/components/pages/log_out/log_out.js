import React from 'react'
import { useAuth } from '../../utils/AuthContext/AuthContext'

function LogOut() {
    const { user, logoutUser } = useAuth()

    return (
        <div className="flex justify-center items-center h-screen bg-[#f8f3ee] overflow-hidden">
            <div className="w-[400px] p-[60px_40px] bg-[#ebd6d2] rounded-[15px] text-center">
                <h2 className="text-[28px] font-light text-[#5e4e4c] mb-6">
                    Biztosan ki szeretne jelentkezni?
                </h2>
                <div className="flex justify-around">
                    <button
                        onClick={logoutUser}
                        className="w-[40%] p-[10px] bg-[#f9f5f2] border border-[#b2a09f] rounded-[30px] text-[18px] font-josefin-slab hover:bg-[#dfbbb0]"
                    >
                        Igen
                    </button>
                    <button
                        onClick={() => window.history.back()} // Navigate back to the previous page
                        className="w-[40%] p-[10px] bg-[#f9f5f2] border border-[#b2a09f] rounded-[30px] text-[18px] font-josefin-slab hover:bg-[#dfbbb0]"
                    >
                        Nem
                    </button>
                </div>
            </div>
        </div>
    )
}

export default LogOut
