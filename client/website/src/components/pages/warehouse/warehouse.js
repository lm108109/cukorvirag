import React, { useState, useEffect } from 'react'
import WarehouseItem from '../../data_containers/WarehouseItem/WarehouseItem'

function Warehouse() {
    const [sortOrder, setSortOrder] = useState('desc')
    const [sweetShopData, setSweetShopData] = useState([])
    const [searchQuery, setSearchQuery] = useState('') // State for search query
    const [error, setError] = useState(null) // For handling errors

    // Filter and sort data
    const sortedData = [...sweetShopData]
        .filter(
            (item) =>
                item.name.toLowerCase().includes(searchQuery.toLowerCase()) // Filter based on search query
        )
        .map((item) => ({
            product: item.name,
            amount: item.quantity,
        }))
        .sort((a, b) => {
            return sortOrder === 'asc'
                ? a.product.localeCompare(b.product)
                : b.product.localeCompare(a.product)
        })

    const sortRecipes = () => {
        setSortOrder(sortOrder === 'asc' ? 'desc' : 'asc')
    }

    const inputHandler = (event) => {
        setSearchQuery(event.target.value) // Update the search query
    }

    useEffect(() => {
        const fetchWareHouseItems = async () => {
            const token = JSON.parse(localStorage.getItem('user'))?.token

            if (!token) {
                setError('No token found. Please log in.')
                return
            }

            const myHeaders = new Headers()
            myHeaders.append('accept', '*/*')
            myHeaders.append('Authorization', `Bearer ${token}`)

            const requestOptions = {
                method: 'GET',
                headers: myHeaders,
                redirect: 'follow',
            }

            try {
                const response = await fetch(
                    'http://localhost:8080/rest/auth/get-storage',
                    requestOptions
                )

                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`)
                }

                const data = await response.json()

                setSweetShopData(data)
            } catch (error) {
                console.error(error)
                setError(error.message)
            }
        }

        fetchWareHouseItems()
    }, [])

    return (
        <>
            <div className="flex flex-col md:flex-row md:flex-wrap md:items-center md:justify-between rounded-lg my-6 mx-5 p-5 bg-[#f7efee] border border-[#2b2b2b]">
                {/* Search input */}
                <input
                    type="text"
                    placeholder="Keresés"
                    className="w-full max-w-sm p-2 rounded-full text-lg bg-[#fdf9f7] my-2 md:my-0"
                    onChange={inputHandler}
                />
                {/* Title and Sort */}
                <div className="flex items-center my-2">
                    <h2 className="text-2xl font-serif text-[#5e1b13] mx-2">
                        Receptek
                    </h2>
                    <span
                        className={`cursor-pointer ml-2 text-lg ${
                            sortOrder === 'desc' ? '▼' : '▲'
                        }`}
                        onClick={sortRecipes}
                    >
                        {sortOrder === 'desc' ? '▼' : '▲'}
                    </span>
                </div>
                <div className="flex items-center">
                    <div className="text-2xl font-serif text-[#5e1b13] mx-2">
                        Mennyiség
                    </div>
                </div>
            </div>
            <div className="font-serif bg-[#f7efee] p-5 rounded-lg my-6 mx-5 border border-[#2b2b2b] flex flex-col overflow-y-auto max-h-[400px] sm:max-h-[600px] lg:max-h-[800px]">
                {error ? (
                    <div className="p-5 text-center text-lg text-red-600 font-serif">
                        {error}
                    </div>
                ) : sortedData.length > 0 ? (
                    <div className="border-t border-[#5e1b13] pt-2 mt-2">
                        {sortedData.map((item, index) => (
                            <WarehouseItem
                                key={index}
                                product={item.product}
                                amount={item.amount}
                                uni={item.unit}
                            />
                        ))}
                    </div>
                ) : (
                    <div className="p-5 text-center text-lg text-[#5e1b13] font-serif">
                        Nincsenek a keresésnek megfelelő receptek
                    </div>
                )}
            </div>
        </>
    )
}

export default Warehouse
