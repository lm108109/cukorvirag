import React, { useState, useEffect } from 'react'
import OrderItem from '../../data_containers/OrderItem/OrderItem'
import { DragDropContext, Droppable, Draggable } from 'react-beautiful-dnd'
import SaveOrder from '../../modal/saveorder'

function Orders() {
    useEffect(() => {
        const fetchOrders = async () => {
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
                    'http://localhost:8080/rest/auth/get-orders',
                    requestOptions
                )

                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`)
                }

                const data = await response.json()

                const filtereNewdOrders = data.filter(
                    (order) => order.status === 'NEW'
                )
                setWaitingOrders(filtereNewdOrders)

                const filtereINProgressdOrders = data.filter(
                    (order) => order.status === 'IN_PROGRESS'
                )
                setProgressOrders(filtereINProgressdOrders)

                const filtereCompletedOrders = data.filter(
                    (order) => order.status === 'FINISHED'
                )
                setCompletedOrders(filtereCompletedOrders)
            } catch (error) {
                console.error(error)
            }
        }

        fetchOrders()
    }, [])

    const [waitingOrders, setWaitingOrders] = useState([])
    const [progressOrders, setProgressOrders] = useState([])
    const [completedOrders, setCompletedOrders] = useState([])
    const [isModalOpen, setIsModalOpen] = useState(false)

    function handleOndragEnd(result) {
        const { source, destination } = result
        if (!destination) return

        const sourceIndex = source.index
        const destinationIndex = destination.index
        const sourceDroppableId = source.droppableId
        const destinationDroppableId = destination.droppableId

        const moveOrder = (
            sourceOrders,
            setSourceOrders,
            destOrders,
            setDestOrders,
            newStatus
        ) => {
            const sourceItems = Array.from(sourceOrders)
            const [movedItem] = sourceItems.splice(sourceIndex, 1)
            movedItem.status = newStatus
            setSourceOrders(sourceItems)

            const destItems = Array.from(destOrders)
            destItems.splice(destinationIndex, 0, movedItem)
            setDestOrders(destItems)
        }

        if (destinationDroppableId === 'waiting') {
            if (sourceDroppableId === 'waiting')
                moveOrder(
                    waitingOrders,
                    setWaitingOrders,
                    waitingOrders,
                    setWaitingOrders,
                    'NEW'
                )
            else if (sourceDroppableId === 'progress')
                moveOrder(
                    progressOrders,
                    setProgressOrders,
                    waitingOrders,
                    setWaitingOrders,
                    'NEW'
                )
            else
                moveOrder(
                    completedOrders,
                    setCompletedOrders,
                    waitingOrders,
                    setWaitingOrders,
                    'NEW'
                )
        } else if (destinationDroppableId === 'progress') {
            if (sourceDroppableId === 'progress')
                moveOrder(
                    progressOrders,
                    setProgressOrders,
                    progressOrders,
                    setProgressOrders,
                    'IN_PROGRESS'
                )
            else if (sourceDroppableId === 'waiting')
                moveOrder(
                    waitingOrders,
                    setWaitingOrders,
                    progressOrders,
                    setProgressOrders,
                    'IN_PROGRESS'
                )
            else
                moveOrder(
                    completedOrders,
                    setCompletedOrders,
                    progressOrders,
                    setProgressOrders,
                    'IN_PROGRESS'
                )
        } else if (destinationDroppableId === 'completed') {
            if (sourceDroppableId === 'completed')
                moveOrder(
                    completedOrders,
                    setCompletedOrders,
                    completedOrders,
                    setCompletedOrders,
                    'FINISHED'
                )
            else if (sourceDroppableId === 'waiting')
                moveOrder(
                    waitingOrders,
                    setWaitingOrders,
                    completedOrders,
                    setCompletedOrders,
                    'FINISHED'
                )
            else
                moveOrder(
                    progressOrders,
                    setProgressOrders,
                    completedOrders,
                    setCompletedOrders,
                    'FINISHED'
                )
        }
    }

    const toggleModal = () => setIsModalOpen(!isModalOpen)

    return (
        <div className="flex flex-col items-center w-auto h-4/5 p-8 relative bg-orders-div m-16 rounded-xl">
            <div className="grid grid-cols-1 md:grid-cols-3 gap-6 w-full">
                <div className="text-center font-bold border-b-2 md:border-none md:border-r-2 border-black py-4">
                    Feldolgozás alatt
                </div>
                <div className="text-center font-bold border-b-2 md:border-none md:border-r-2 border-black py-4">
                    Folyamatban
                </div>
                <div className="text-center font-bold border-b-2 md:border-none py-4">
                    Befejezett
                </div>
            </div>

            <DragDropContext onDragEnd={handleOndragEnd}>
                <div className="grid grid-cols-1 md:grid-cols-3 gap-6 w-full h-full mb-16">
                    <Droppable droppableId="waiting">
                        {(provided) => (
                            <div
                                className="bg-white p-4 rounded-lg shadow-lg h-full overflow-y-auto"
                                {...provided.droppableProps}
                                ref={provided.innerRef}
                            >
                                {waitingOrders.map(
                                    (
                                        {
                                            sweetName,
                                            quantity,
                                            price,
                                            status,
                                            name,
                                            telephoneNumber,
                                            email,
                                            date,
                                        },
                                        index
                                    ) => (
                                        <Draggable
                                            key={telephoneNumber + email}
                                            draggableId={
                                                telephoneNumber + email
                                            }
                                            index={index}
                                        >
                                            {(provided) => (
                                                <div
                                                    className="mb-4"
                                                    ref={provided.innerRef}
                                                    {...provided.draggableProps}
                                                    {...provided.dragHandleProps}
                                                >
                                                    <OrderItem
                                                        sweetName={sweetName}
                                                        quantity={quantity}
                                                        price={price}
                                                        process={status}
                                                        name={name}
                                                        phone_number={
                                                            telephoneNumber
                                                        }
                                                    />
                                                </div>
                                            )}
                                        </Draggable>
                                    )
                                )}
                                {provided.placeholder}
                            </div>
                        )}
                    </Droppable>
                    <Droppable droppableId="progress">
                        {(provided) => (
                            <div
                                className="bg-white p-4 rounded-lg shadow-lg h-full overflow-y-auto"
                                {...provided.droppableProps}
                                ref={provided.innerRef}
                            >
                                {progressOrders.map(
                                    (
                                        {
                                            sweetName,
                                            quantity,
                                            price,
                                            status,
                                            name,
                                            telephoneNumber,
                                            email,
                                            date,
                                        },
                                        index
                                    ) => (
                                        <Draggable
                                            key={telephoneNumber + email}
                                            draggableId={
                                                telephoneNumber + email
                                            }
                                            index={index}
                                        >
                                            {(provided) => (
                                                <div
                                                    className="mb-4"
                                                    ref={provided.innerRef}
                                                    {...provided.draggableProps}
                                                    {...provided.dragHandleProps}
                                                >
                                                    <OrderItem
                                                        sweetName={sweetName}
                                                        quantity={quantity}
                                                        price={price}
                                                        process={status}
                                                        name={name}
                                                        phone_number={
                                                            telephoneNumber
                                                        }
                                                    />
                                                </div>
                                            )}
                                        </Draggable>
                                    )
                                )}
                                {provided.placeholder}
                            </div>
                        )}
                    </Droppable>
                    <Droppable droppableId="completed">
                        {(provided) => (
                            <div
                                className="bg-white p-4 rounded-lg shadow-lg h-full flex-grow overflow-auto"
                                {...provided.droppableProps}
                                ref={provided.innerRef}
                            >
                                {completedOrders.map(
                                    (
                                        {
                                            sweetName,
                                            quantity,
                                            price,
                                            status,
                                            name,
                                            telephoneNumber,
                                            email,
                                            date,
                                        },
                                        index
                                    ) => (
                                        <Draggable
                                            key={telephoneNumber + email}
                                            draggableId={
                                                telephoneNumber + email
                                            }
                                            index={index}
                                        >
                                            {(provided) => (
                                                <div
                                                    className="mb-4"
                                                    ref={provided.innerRef}
                                                    {...provided.draggableProps}
                                                    {...provided.dragHandleProps}
                                                >
                                                    <OrderItem
                                                        sweetName={sweetName}
                                                        quantity={quantity}
                                                        price={price}
                                                        process={status}
                                                        name={name}
                                                        phone_number={
                                                            telephoneNumber
                                                        }
                                                    />
                                                </div>
                                            )}
                                        </Draggable>
                                    )
                                )}
                                {provided.placeholder}
                            </div>
                        )}
                    </Droppable>
                </div>
            </DragDropContext>

            {/* Modal toggle button */}
            <button
                onClick={toggleModal}
                className="fixed z-10 bottom-5 left-5 w-16 h-16 bg-orders-div border-2 border-black rounded-full flex justify-center items-center shadow-lg hover:bg-gray-200 transition duration-300"
            >
                +
            </button>

            {/* Render Modal */}
            {isModalOpen && <SaveOrder onClose={toggleModal} />}
        </div>
    )
}

export default Orders
