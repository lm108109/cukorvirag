import React, { useState } from 'react'
import './orders.css'
import OrderItem from '../../data_containers/OrderItem/OrderItem'
import { DragDropContext, Droppable, Draggable } from 'react-beautiful-dnd'

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

    function handleOndragEnd(result) {
        const { source, destination } = result

        if (!destination) return

        const source_index = source.index
        const destination_index = destination.index

        const source_droppableId = source.droppableId
        const destination_droppableId = destination.droppableId

        //waiting orders
        if (destination_droppableId === 'waiting') {
            if (source_droppableId === 'waiting') {
                const items = Array.from(waitingOrders)
                const [reorderedItem] = items.splice(source_index, 1)
                items.splice(destination_index, 0, reorderedItem)

                setWaitingOrders(items)
            }

            if (source_droppableId === 'progress') {
                const items = Array.from(waitingOrders)
                const progress_items = Array.from(progressOrders)
                //take from progress the dragged item
                const [reorderedItem] = progress_items.splice(source_index, 1)
                reorderedItem.status = 'Waiting for Processing'
                setProgressOrders(progress_items)

                items.splice(destination_index, 0, reorderedItem)

                setWaitingOrders(items)
            }

            if (source_droppableId === 'completed') {
                const items = Array.from(waitingOrders)
                const completed_items = Array.from(completedOrders)
                //take from progress the dragged item
                const [reorderedItem] = completed_items.splice(source_index, 1)
                reorderedItem.status = 'Waiting for Processing'
                setCompletedOrders(completed_items)

                items.splice(destination_index, 0, reorderedItem)

                setWaitingOrders(items)
            }
        }

        //progress orders
        if (destination_droppableId === 'progress') {
            if (source_droppableId === 'progress') {
                const items = Array.from(progressOrders)
                const [reorderedItem] = items.splice(source_index, 1)
                items.splice(destination_index, 0, reorderedItem)

                setProgressOrders(items)
            }

            if (source_droppableId === 'waiting') {
                const items = Array.from(progressOrders)
                const waiting_items = Array.from(waitingOrders)
                //take from progress the dragged item
                const [reorderedItem] = waiting_items.splice(source_index, 1)
                reorderedItem.status = 'In Progress'
                setWaitingOrders(waiting_items)

                items.splice(destination_index, 0, reorderedItem)

                setProgressOrders(items)
            }

            if (source_droppableId === 'completed') {
                const items = Array.from(progressOrders)
                const completed_items = Array.from(completedOrders)
                //take from progress the dragged item
                const [reorderedItem] = completed_items.splice(source_index, 1)
                reorderedItem.status = 'In Progress'
                setCompletedOrders(completed_items)

                items.splice(destination_index, 0, reorderedItem)

                setProgressOrders(items)
            }
        }
        //completed orders
        if (destination_droppableId === 'completed') {
            if (source_droppableId === 'completed') {
                const items = Array.from(completedOrders)
                const [reorderedItem] = items.splice(source_index, 1)
                items.splice(destination_index, 0, reorderedItem)

                setCompletedOrders(items)
            }

            if (source_droppableId === 'waiting') {
                const items = Array.from(completedOrders)
                const waiting_items = Array.from(waitingOrders)
                //take from progress the dragged item
                const [reorderedItem] = waiting_items.splice(source_index, 1)
                reorderedItem.status = 'Completed'
                setWaitingOrders(waiting_items)

                items.splice(destination_index, 0, reorderedItem)

                setCompletedOrders(items)
            }

            if (source_droppableId === 'progress') {
                const items = Array.from(completedOrders)
                const progress_items = Array.from(progressOrders)
                //take from progress the dragged item
                const [reorderedItem] = progress_items.splice(source_index, 1)
                reorderedItem.status = 'Completed'
                setProgressOrders(progress_items)

                items.splice(destination_index, 0, reorderedItem)

                setCompletedOrders(items)
            }
        }
    }

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
                    {/* Added bottom margin */}
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

            {/* Adjusted button with margins */}
            <div>
                <button className="fixed z-10 bottom-5 left-5 w-16 h-16 bg-orders-div border-2 border-black rounded-full flex justify-center items-center shadow-lg hover:bg-gray-200 transition duration-300">
                    +
                </button>
            </div>
        </div>
    )
}

export default Orders
