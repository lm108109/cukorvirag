import React, { useState, useEffect } from 'react'
import { useAuth } from '../../utils/AuthContext/AuthContext'
import { useNavigate } from 'react-router-dom'

function LogIn() {
    const navigate = useNavigate()
    const { user, loginUser } = useAuth()

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')

    useEffect(() => {
        if (user) {
            navigate('/home')
        }
    }, [user, navigate])

    const handleSubmit = async (e) => {
        e.preventDefault()
        const success = await loginUser({ username, password })
        if (success) {
            navigate('/home')
        } else {
            alert('Login failed. Please check your credentials.')
        }
    }

    return (
        <div className="flex justify-center items-center h-screen bg-[#f8f3ee] overflow-hidden">
            <div className="w-[400px] p-[60px_40px] bg-[#ebd6d2] rounded-[15px]">
                <h2 className="text-center mb-8 text-[28px] font-light text-[#5e4e4c]">
                    Bejelentkezés
                </h2>
                <form onSubmit={handleSubmit}>
                    <input
                        type="text"
                        placeholder="Felhasználónév"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        className="w-full p-[15px] mb-4 border-none bg-[#f9f5f2] rounded-[10px] text-[18px] font-josefin-slab"
                    />
                    <input
                        type="password"
                        placeholder="Jelszó"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        className="w-full p-[15px] mb-4 border-none bg-[#f9f5f2] rounded-[10px] text-[18px] font-josefin-slab"
                    />
                    <button
                        type="submit"
                        className="block w-[40%] mx-auto p-[10px] mt-5 bg-[#f9f5f2] border border-[#b2a09f] rounded-[30px] text-[18px] font-josefin-slab hover:bg-[#dfbbb0]"
                    >
                        Mehet
                    </button>
                </form>
            </div>
        </div>
    )
}

export default LogIn
