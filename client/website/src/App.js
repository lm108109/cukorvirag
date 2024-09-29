import { BrowserRouter as Router } from 'react-router-dom';
import Header from './components/header/header';
import NavRoutes from './components/utils/navroutes/navroutes';
import { AuthProvider } from './components/utils/AuthContext/AuthContext';
import './App.css';

function App() {
  return (
    <div className="App">
      <Router>
        <AuthProvider>
          <Header />
          <div className="main-content">
            <NavRoutes />
          </div>
        </AuthProvider>
      </Router>
    </div>
  );
}

export default App;
