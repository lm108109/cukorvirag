import React, { useState, useEffect } from 'react'
import WarehouseItem from '../../data_containers/WarehouseItem/WarehouseItem'

function Warehouse() {
    const [sortOrder, setSortOrder] = useState('desc')
    const [sweetShopData, setSweetShopData] = useState([])
    const [searchQuery, setSearchQuery] = useState('') // State for search query

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
                console.error('No token found. Please log in.')
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
            }
        }

        fetchWareHouseItems()
    }, [])

    return (
        <div className="m-12 p-4 bg-gray-100 rounded-lg flex flex-col">
            <div className="border-b-2 border-black w-full flex justify-between text-xl py-2 bg-white z-10 sticky top-0 shadow-md">
                {/* Search input */}
                <input
                    type="text"
                    placeholder="Keresés"
                    className="w-full max-w-sm p-2 rounded-full text-lg bg-[#fdf9f7] my-2 md:my-0"
                    onChange={inputHandler} // Handle input change
                />
                <div className="flex items-center">
                    <div className="mr-2">Megnevezés</div>
                    <span
                        className={`cursor-pointer ml-2 ${
                            sortOrder === 'desc' ? 'arrow-down' : 'arrow-up'
                        }`}
                        onClick={sortRecipes}
                    >
                        {sortOrder === 'desc' ? '▼' : '▲'}
                    </span>
                </div>
                <div className="flex items-center">
                    <div className="mr-2">Mennyiség</div>
                </div>
            </div>
            <div className="flex-grow w-full h-full overflow-y-auto bg-gray-100">
                {sortedData.length > 0 ? (
                    <div className="list-none">
                        {sortedData.map((item, index) => (
                            <WarehouseItem
                                key={index}
                                product={item.product}
                                amount={item.amount}
                                unit={item.unit}
                            />
                        ))}
                    </div>
                ) : (
                    <div className="text-center">
                        Nincsenek a keresésnek megfelelő receptek
                    </div>
                )}
            </div>
        </div>
    )
}

export default Warehouse
