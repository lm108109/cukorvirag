import React, { useState } from 'react'
import './orders.css'
import OrderItem from '../../data_containers/OrderItem/OrderItem'
import { DragDropContext, Droppable, Draggable } from 'react-beautiful-dnd'
import SaveOrder from '../../modal/saveorder'

function Orders() {
    const initialWaiting = [
        {
            id: 'order-1',
            sweetName: 'Csoki torta',
            quantity: 2,
            price: 15,
            status: 'Waiting for Processing',
        },
        {
            id: 'order-2',
            sweetName: 'Sajt torta',
            quantity: 2,
            price: 15,
            status: 'Waiting for Processing',
        },
    ]
    const initialProgress = [
        {
            id: 'order-4',
            sweetName: 'Strawberry Tart',
            quantity: 1,
            price: 8,
            status: 'In Progress',
        },
        {
            id: 'order-5',
            sweetName: 'Somlói',
            quantity: 2,
            price: 15,
            status: 'In Progress',
        },
    ]
    const initialCompleted = [
        {
            id: 'order-6',
            sweetName: 'Macarons',
            quantity: 5,
            price: 12,
            status: 'Completed',
        },
        {
            id: 'order-7',
            sweetName: 'Sajt torta',
            quantity: 5,
            price: 12,
            status: 'Completed',
        },
    ]

    const [waitingOrders, setWaitingOrders] = useState(initialWaiting)
    const [progressOrders, setProgressOrders] = useState(initialProgress)
    const [completedOrders, setCompletedOrders] = useState(initialCompleted)
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
                    'Waiting for Processing'
                )
            else if (sourceDroppableId === 'progress')
                moveOrder(
                    progressOrders,
                    setProgressOrders,
                    waitingOrders,
                    setWaitingOrders,
                    'Waiting for Processing'
                )
            else
                moveOrder(
                    completedOrders,
                    setCompletedOrders,
                    waitingOrders,
                    setWaitingOrders,
                    'Waiting for Processing'
                )
        } else if (destinationDroppableId === 'progress') {
            if (sourceDroppableId === 'progress')
                moveOrder(
                    progressOrders,
                    setProgressOrders,
                    progressOrders,
                    setProgressOrders,
                    'In Progress'
                )
            else if (sourceDroppableId === 'waiting')
                moveOrder(
                    waitingOrders,
                    setWaitingOrders,
                    progressOrders,
                    setProgressOrders,
                    'In Progress'
                )
            else
                moveOrder(
                    completedOrders,
                    setCompletedOrders,
                    progressOrders,
                    setProgressOrders,
                    'In Progress'
                )
        } else if (destinationDroppableId === 'completed') {
            if (sourceDroppableId === 'completed')
                moveOrder(
                    completedOrders,
                    setCompletedOrders,
                    completedOrders,
                    setCompletedOrders,
                    'Completed'
                )
            else if (sourceDroppableId === 'waiting')
                moveOrder(
                    waitingOrders,
                    setWaitingOrders,
                    completedOrders,
                    setCompletedOrders,
                    'Completed'
                )
            else
                moveOrder(
                    progressOrders,
                    setProgressOrders,
                    completedOrders,
                    setCompletedOrders,
                    'Completed'
                )
        }
    }

    const toggleModal = () => setIsModalOpen(!isModalOpen)

    return (
        <div className="flex flex-col items-center w-auto h-4/5 p-8 relative bg-orders-div m-16 rounded-xl">
            <div className="grid grid-cols-1 md:grid-cols-3 gap-6 w-full">
                <div className="text-center font-bold border-b-2 md:border-none md:border-r-2 border-black py-4">
                    Waiting for Processing
                </div>
                <div className="text-center font-bold border-b-2 md:border-none md:border-r-2 border-black py-4">
                    In Progress
                </div>
                <div className="text-center font-bold border-b-2 md:border-none py-4">
                    Completed
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
                                            id,
                                            sweetName,
                                            quantity,
                                            price,
                                            status,
                                        },
                                        index
                                    ) => (
                                        <Draggable
                                            key={id}
                                            draggableId={id}
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
                                            id,
                                            sweetName,
                                            quantity,
                                            price,
                                            status,
                                        },
                                        index
                                    ) => (
                                        <Draggable
                                            key={id}
                                            draggableId={id}
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
                                            id,
                                            sweetName,
                                            quantity,
                                            price,
                                            status,
                                        },
                                        index
                                    ) => (
                                        <Draggable
                                            key={id}
                                            draggableId={id}
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
