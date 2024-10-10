import { BrowserRouter as Router } from 'react-router-dom'
import Header from './components/header/header'
import NavRoutes from './components/utils/navroutes/navroutes'
import { AuthProvider } from './components/utils/AuthContext/AuthContext'
import Main from './components/main/main'
import './App.css'

function App() {
    return (
        <div className="flex flex-col h-screen">
            <Router>
                <AuthProvider>
                    <Header />
                    <Main />
                </AuthProvider>
            </Router>
        </div>
    )
}

export default App
