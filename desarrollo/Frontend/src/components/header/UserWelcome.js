import { useContext, useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import AuthContext from "../../contexts/AuthContext";
import { useStateContext } from "../../contexts/ContextProvider";
import "./userWelcome.css";

const UserWelcome = ({ handleLogout }) => {
  const [avatar, setAvatar] = useState("");
  const [nombre, setNombre] = useState("");
  const [apellido, setApellido] = useState("");
  const { isLoggedIn, validateToken } = useContext(AuthContext);
  const { loading } = useStateContext();
  const { pathname: currentLocation } = useLocation();

  useEffect(() => {
    if (validateToken()) {
      setAvatar(
        `${JSON.parse(localStorage.getItem("user"))
          .nombre.slice(0, 1)
          .toUpperCase()}${JSON.parse(localStorage.getItem("user"))
          .apellido.slice(0, 1)
          .toUpperCase()}`
      );
      setNombre(JSON.parse(localStorage.getItem("user")).nombre);
      setApellido(JSON.parse(localStorage.getItem("user")).apellido);
    }
  }, [loading, isLoggedIn]);

  return (
    <div className="user-loggedIn-main-container">
      <div className="user-avatar-container">
        <h2>{avatar}</h2>
      </div>
      <div className="user-welcome-container">
        <ul type="none">
          <li>
            <p aria-label="user-welcome">Hola, </p>
          </li>
          <li className="user-welcome-username">
            <p>{`${nombre} ${apellido}`}</p>
          </li>
        </ul>
        <div className="user-logout-container" onClick={handleLogout}>
          <i className="fa-solid fa-xmark"></i>
        </div>
      </div>
    </div>
  );
};

export default UserWelcome;
