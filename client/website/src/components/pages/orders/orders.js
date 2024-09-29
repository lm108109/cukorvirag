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
        <div className="orders-container">
            <div className="header-for-children">
                <div className="header-item">Feldolgozásra vár</div>
                <div className="header-item">Készül</div>
                <div className="header-item">Elkészült</div>
            </div>
            <div className="content-container">
                <DragDropContext onDragEnd={handleOndragEnd}>
                    <div className="processing-container">
                        <div className="order-list">
                            <Droppable droppableId="waiting">
                                {(provided) => (
                                    <ul
                                        className="waitingOrders"
                                        {...provided.droppableProps} // Spread droppableProps
                                        ref={provided.innerRef} // Attach innerRef
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
                                                    key={id} // Use the unique id as key
                                                    draggableId={id} // Use the unique id for draggableId
                                                    index={index} // Index is still based on array position
                                                >
                                                    {(provided) => (
                                                        <li
                                                            {...provided.draggableProps} // Draggable props
                                                            {...provided.dragHandleProps} // Drag handle props
                                                            ref={
                                                                provided.innerRef
                                                            } // Ref for the draggable item
                                                        >
                                                            <OrderItem
                                                                sweetName={
                                                                    sweetName
                                                                }
                                                                quantity={
                                                                    quantity
                                                                }
                                                                price={price}
                                                                process={status}
                                                            />
                                                        </li>
                                                    )}
                                                </Draggable>
                                            )
                                        )}
                                        {provided.placeholder}
                                    </ul>
                                )}
                            </Droppable>
                        </div>
                    </div>
                    <div className="about-container">
                        <Droppable droppableId="progress">
                            {(provided) => (
                                <ul
                                    className="progressOrders"
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
                                                    <li
                                                        {...provided.draggableProps}
                                                        {...provided.dragHandleProps}
                                                        ref={provided.innerRef}
                                                    >
                                                        <OrderItem
                                                            sweetName={
                                                                sweetName
                                                            }
                                                            quantity={quantity}
                                                            price={price}
                                                            process={status}
                                                        />
                                                    </li>
                                                )}
                                            </Draggable>
                                        )
                                    )}
                                    {provided.placeholder}
                                </ul>
                            )}
                        </Droppable>
                    </div>
                    <div className="ready-container">
                        <Droppable droppableId="completed">
                            {(provided) => (
                                <ul
                                    className="completedOrders"
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
                                                    <li
                                                        {...provided.draggableProps}
                                                        {...provided.dragHandleProps}
                                                        ref={provided.innerRef}
                                                    >
                                                        <OrderItem
                                                            sweetName={
                                                                sweetName
                                                            }
                                                            quantity={quantity}
                                                            price={price}
                                                            process={status}
                                                        />
                                                    </li>
                                                )}
                                            </Draggable>
                                        )
                                    )}
                                    {provided.placeholder}
                                </ul>
                            )}
                        </Droppable>
                    </div>
                </DragDropContext>
            </div>
            <div>
                <button className="floating-button">+</button>
            </div>
        </div>
    )
}

export default Orders
