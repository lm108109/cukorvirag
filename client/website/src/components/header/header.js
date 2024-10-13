import React from 'react'
import { NavLink } from 'react-router-dom'
import { useAuth } from '../utils/AuthContext/AuthContext'

function Header() {
    const { user } = useAuth()
    return (
        <div className="w-full fixed top-0 left-0 z-1000 bg-header-bg-color p-4 h-[160px] md:h-[120px] flex flex-col md:flex-row justify-between items-center">
            <header className="w-full flex flex-col md:flex-row justify-between items-center">
                {/* First Navigation (Links on the Left) */}
                <div className="flex-1 w-full md:w-auto mb-4 md:mb-0">
                    <nav className="flex flex-row justify-around items-center">
                        {user ? (
                            <ul className="flex flex-row flex-wrap space-x-4 text-lg md:text-xl">
                                <li className="mx-4">
                                    <NavLink
                                        to="/home"
                                        className={({ isActive }) =>
                                            isActive
                                                ? 'underline text-black'
                                                : 'no-underline text-black'
                                        }
                                    >
                                        Home
                                    </NavLink>
                                </li>
                                <li className="mx-4">
                                    <NavLink
                                        to="/warehouse"
                                        className={({ isActive }) =>
                                            isActive
                                                ? 'underline text-black'
                                                : 'no-underline text-black'
                                        }
                                    >
                                        Raktár
                                    </NavLink>
                                </li>
                                <li className="mx-4">
                                    <NavLink
                                        to="/orders"
                                        className={({ isActive }) =>
                                            isActive
                                                ? 'underline text-black'
                                                : 'no-underline text-black'
                                        }
                                    >
                                        Rendelések
                                    </NavLink>
                                </li>
                                <li className="mx-4">
                                    <NavLink
                                        to="/recipes"
                                        className={({ isActive }) =>
                                            isActive
                                                ? 'underline text-black'
                                                : 'no-underline text-black'
                                        }
                                    >
                                        Receptek
                                    </NavLink>
                                </li>
                                <li className="mx-4">
                                    <NavLink
                                        to="/contact"
                                        className={({ isActive }) =>
                                            isActive
                                                ? 'underline text-black'
                                                : 'no-underline text-black'
                                        }
                                    >
                                        Kapcsolat
                                    </NavLink>
                                </li>
                            </ul>
                        ) : null}
                    </nav>
                </div>

                {/* Logo in the Center */}
                <div className="mx-4 flex justify-center w-full md:w-auto">
                    <img
                        src={`${process.env.PUBLIC_URL}/sugar_flower.png`}
                        alt="Sugar Flower"
                        className="max-w-[120px] max-h-[80px] md:max-w-[150px] md:max-h-[100px] border border-black"
                    />
                </div>

                {/* Second Navigation (Logout on the Right) */}
                <div className="flex-1 w-full md:w-auto mt-4 md:mt-0">
                    <nav className="flex flex-row justify-around items-center">
                        {user ? (
                            <ul className="flex flex-row flex-wrap space-x-4 text-lg md:text-xl">
                                <li className="mx-4">
                                    <NavLink
                                        to="/logout"
                                        className={({ isActive }) =>
                                            isActive
                                                ? 'underline text-black'
                                                : 'no-underline text-black'
                                        }
                                    >
                                        Kijelentkezés
                                    </NavLink>
                                </li>
                            </ul>
                        ) : null}
                    </nav>
                </div>
            </header>
        </div>
    )
}

export default Header
