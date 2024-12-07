import React, { useState } from 'react'

const SaveOrder = ({ onClose }) => {
    // State for form fields
    const [sweetName, setSweetName] = useState('')
    const [quantity, setQuantity] = useState(0)
    const [price, setPrice] = useState(0)
    const [status, setStatus] = useState('Waiting for Processing')
    const [name, setName] = useState('')
    const [phoneNumber, setPhoneNumber] = useState('')
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
            status,
            name,
            phoneNumber,
            email,
            date,
        }

        console.log('Form Data:', formData) // You can replace this with save logic
        onClose() // Close the modal after submission
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
                            placeholder="Sweet Name"
                            value={sweetName}
                            onChange={(e) => setSweetName(e.target.value)}
                            className="border p-2 rounded"
                        />
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
                            placeholder="Name"
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                            className="border p-2 rounded"
                        />
                        <input
                            type="tel"
                            placeholder="Phone Number"
                            value={phoneNumber}
                            onChange={(e) => setPhoneNumber(e.target.value)}
                            className="border p-2 rounded"
                        />
                        <input
                            type="email"
                            placeholder="Email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            className="border p-2 rounded"
                        />
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
