import React, { useState, useEffect } from 'react'
import SaveOrder from '../../modal/saveorder'

const Home = () => {
    const [time, setTime] = useState('')
    const [date, setDate] = useState('')
    const [isModalOpen, setIsModalOpen] = useState(false)

    useEffect(() => {
        const updateTimeAndDate = () => {
            const now = new Date()
            const hours = String(now.getHours()).padStart(2, '0')
            const minutes = String(now.getMinutes()).padStart(2, '0')
            const day = String(now.getDate()).padStart(2, '0')
            let month = now.toLocaleString('hu-HU', { month: 'long' })
            month = month.charAt(0).toUpperCase() + month.slice(1)
            const year = now.getFullYear()

            setTime(`${hours}:${minutes}`)
            setDate(`${year}. ${month} ${day}.`)
        }

        updateTimeAndDate()
        const intervalId = setInterval(updateTimeAndDate, 1000)

        return () => clearInterval(intervalId)
    }, [])

    const toggleModal = () => setIsModalOpen(!isModalOpen)

    return (
        <div className="flex flex-col items-center justify-center h-screen bg-[#fdf8f5] text-[#2b2b2b] font-josefin-slab">
            <div className="text-center mb-5">
                <h1 className="text-[100px] font-light m-0">{time}</h1>
                <p className="text-[30px] m-0">{date}</p>
            </div>
            <div className="italic font-bold text-center max-w-xs text-[22px] leading-relaxed mt-5">
                <p>“Édes pillanatok, melyek virágba borítják a napodat!”</p>
            </div>
            <button
                onClick={toggleModal}
                className="absolute bottom-5 left-5 w-[50px] h-[50px] text-[30px] border-2 border-black rounded-full flex items-center justify-center hover:bg-gray-300"
            >
                +
            </button>

            {/* Modal component, rendered conditionally */}
            {isModalOpen && <SaveOrder onClose={toggleModal} />}
        </div>
    )
}

export default Home
