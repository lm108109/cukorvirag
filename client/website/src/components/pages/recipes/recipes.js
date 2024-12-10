import React, { useState, useEffect } from 'react'
import RecipeItem from '../../data_containers/RecipeItem/RecipeItem'

const Recipes = () => {
    const [inputText, setInputText] = useState('')
    const [sortOrder, setSortOrder] = useState('desc')
    const [recipes, setRecipes] = useState([]) // Initialize as empty
    const [error, setError] = useState(null) // For handling errors

    // Handler for the search input
    const inputHandler = (e) => {
        const lowerCase = e.target.value.toLowerCase()
        setInputText(lowerCase)
    }

    // Sort recipes by the current sort order
    const sortRecipes = () => {
        const sortedRecipes = [...recipes].sort((a, b) => {
            if (sortOrder === 'desc') {
                return a.name.localeCompare(b.name)
            } else {
                return b.name.localeCompare(a.name)
            }
        })
        setRecipes(sortedRecipes)
        setSortOrder(sortOrder === 'asc' ? 'desc' : 'asc')
    }

    // Fetch recipes from the API
    useEffect(() => {
        const fetchRecipes = async () => {
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
                    'http://localhost:8080/rest/auth/get-cookies',
                    requestOptions
                )

                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`)
                }

                const data = await response.json() // Parse as JSON
                setRecipes(data) // Assuming data is an array of objects
            } catch (error) {
                console.error(error)
                setError(error.message)
            }
        }

        fetchRecipes()
    }, []) // Run on component mount

    // Filter recipes based on the search input
    const filteredRecipes = recipes.filter((recipe, description) => {
        if (inputText === '') {
            return true // Return all recipes when inputText is empty
        } else {
            return recipe.name.toLowerCase().includes(inputText)
        }
    })

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
            </div>
            <div className="font-serif bg-[#f7efee] p-5 rounded-lg my-6 mx-5 border border-[#2b2b2b] flex flex-col overflow-y-auto max-h-[400px] sm:max-h-[600px] lg:max-h-[800px]">
                {error ? (
                    <div className="p-5 text-center text-lg text-red-600 font-serif">
                        {error}
                    </div>
                ) : filteredRecipes.length >= 1 ? (
                    <div className="border-t border-[#5e1b13] pt-2 mt-2">
                        {filteredRecipes.map((recipe, index) => (
                            <RecipeItem
                                key={index}
                                title={recipe.name}
                                description={recipe.description}
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

export default Recipes
