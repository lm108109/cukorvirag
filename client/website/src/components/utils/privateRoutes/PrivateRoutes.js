import { Outlet, Navigate } from 'react-router-dom';
import { useAuth } from '../AuthContext/AuthContext';

const PrivateRoutes = () => {
  // This should come from your authentication logic (e.g., context or state)
  const { user } = useAuth(); // Replace with actual authentication check

  return user ? <Outlet /> : <Navigate to="/login" />;
};

export default PrivateRoutes;
