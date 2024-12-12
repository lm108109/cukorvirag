import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const SaveOrder = ({ onClose, onSave }) => {
    const navigate = useNavigate()
    // State for form fields
    const [sweetName, setSweetName] = useState('')
    const [quantity, setQuantity] = useState(0)
    const [price, setPrice] = useState(0)
    const [name, setName] = useState('')
    const [telephoneNumber, settelephoneNumber] = useState('')
    const [email, setEmail] = useState('')
    const [date, setDate] = useState('')

    // Handle form submission
    const handleSubmit = (e) => {
        e.preventDefault()

        // Create an object with the form data
        const formData = {
            sweetName,
            quantity,
            price,
            name,
            telephoneNumber,
            email,
            date,
        }

        console.log('Form Data:', formData) // You can replace this with save logic

        // Construct the query string from the form data
        const queryString = new URLSearchParams(formData).toString()

        // Define the API URL
        const apiUrl = `http://localhost:8080/rest/auth/add-order?${queryString}`

        const token = JSON.parse(localStorage.getItem('user'))?.token

        // Make the API request
        const myHeaders = new Headers()
        myHeaders.append('accept', '*/*')
        myHeaders.append('Authorization', `Bearer ${token}`)

        const requestOptions = {
            method: 'POST',
            headers: myHeaders,
            redirect: 'follow',
        }

        fetch(apiUrl, requestOptions)
            .then((response) => response.text())
            .then((result) => {
                // console.log('Order successfully added:', result)
                onClose()
                onSave()
                navigate('/orders')
            })
            .catch((error) => {
                console.error('Error adding order:', error)
            })
    }

    return (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
            <div className="bg-header-bg-color rounded-lg shadow-lg p-6 max-w-lg w-full">
                <div className="flex justify-between items-center mb-4">
                    <h2 className="text-xl font-semibold">
                        Új rendelés felvétele
                    </h2>
                    <button
                        onClick={onClose}
                        className="text-gray-400 hover:text-gray-600"
                    >
                        x
                    </button>
                </div>

                {/* Form Fields */}
                <form onSubmit={handleSubmit}>
                    <div className="flex flex-col gap-4">
                        <input
                            type="text"
                            placeholder="Édesség neve"
                            value={sweetName}
                            onChange={(e) => setSweetName(e.target.value)}
                            className="border p-2 rounded"
                        />
                        <div>Darabszám</div>
                        <input
                            type="number"
                            placeholder="Quantity"
                            value={quantity}
                            onChange={(e) =>
                                setQuantity(Number(e.target.value))
                            }
                            className="border p-2 rounded"
                        />
                        <input
                            type="text"
                            placeholder="Rendelő neve"
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                            className="border p-2 rounded"
                        />
                        <div>Ár</div>
                        <input
                            type="number"
                            placeholder="Price"
                            value={price}
                            onChange={(e) => setPrice(Number(e.target.value))}
                            className="border p-2 rounded"
                        />
                        <input
                            type="tel"
                            placeholder="Telefonszám"
                            value={telephoneNumber}
                            onChange={(e) => settelephoneNumber(e.target.value)}
                            className="border p-2 rounded"
                        />
                        <input
                            type="email"
                            placeholder="Email cím"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            className="border p-2 rounded"
                        />
                        <div>Dátum</div>
                        <input
                            type="date"
                            value={date}
                            onChange={(e) => setDate(e.target.value)}
                            className="border p-2 rounded"
                        />
                    </div>

                    {/* Submit Button */}
                    <div className="flex justify-end mt-4">
                        <button
                            type="submit"
                            className="px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
                        >
                            Save
                        </button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default SaveOrder
