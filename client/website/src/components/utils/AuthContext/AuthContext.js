import { useContext, useState, useEffect, createContext } from 'react'

const AuthContext = createContext()

export const AuthProvider = ({ children }) => {
    const [loading, setLoading] = useState(true)
    const [user, setUser] = useState(null)

    useEffect(() => {
        // Simulate checking user status or initializing from a token
        const storedUser = localStorage.getItem('user')
        if (storedUser) {
            setUser(JSON.parse(storedUser))
        }
        setLoading(false)
    }, [])

    const loginUser = async ({ username, password }) => {
        try {
            const response = await fetch(
                'http://localhost:8080/rest/auth/login',
                {
                    method: 'POST',
                    headers: {
                        Accept: '*/*',
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({ username, password }),
                }
            )

            if (response.ok) {
                const result = await response.json()
                setUser(result) // Update user with API response (e.g., token or user details)
                localStorage.setItem('user', JSON.stringify(result)) // Persist user data
                return true
            } else {
                return false
            }
        } catch (error) {
            console.error('Login error:', error)
            return false
        }
    }

    const logoutUser = () => {
        setUser(null)
        localStorage.removeItem('user')
    }

    const registerUser = async (userInfo) => {
        // Implement registration logic
    }

    const contextData = { user, loginUser, logoutUser, registerUser }

    return (
        <AuthContext.Provider value={contextData}>
            {loading ? <p>Loading...</p> : children}
        </AuthContext.Provider>
    )
}

export const useAuth = () => {
    return useContext(AuthContext)
}

export default AuthContext
