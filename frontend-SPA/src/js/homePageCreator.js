import {
    displayMyPage
} from './myCalendar.js';

let user;

const renderHeader = () => {
    const headerElement = document.createElement("header");
    headerElement.classList.add("header");
    headerElement.innerText = "TimeTo";
    return headerElement;
}

const renderFooter = () => {
    const footerElement = document.createElement("footer");
    footerElement.classList.add("footer");
    footerElement.innerText = "© TimeTo 2020";
    return footerElement;
}

const renderLogin = () => {
    const mainSection = document.createElement("main");
    mainSection.classList.add("main");

    const loginSection = document.createElement("section");
    loginSection.classList.add("login");
    mainSection.appendChild(loginSection);

    const signIn = document.createElement("p");
    signIn.classList.add("signIn");
    loginSection.appendChild(signIn);
    signIn.innerText = "Sign In!"


    const loginForm = document.createElement("form");
    loginForm.classList.add("loginForm");
    loginSection.appendChild(loginForm);

    const usernameInput = document.createElement("input");
    usernameInput.setAttribute("placeholder", "Username");
    loginForm.appendChild(usernameInput);

    const passwordInput = document.createElement("input");
    passwordInput.setAttribute("placeholder", "Password");
    loginForm.appendChild(passwordInput);

    const loginButton = document.createElement("button");
    loginButton.classList.add("loginButton");
    loginButton.innerText = "Log In";
    loginForm.appendChild(loginButton);

    const space = document.createElement("p");
    loginForm.appendChild(space);

    const forgotPW = document.createElement("a");
    forgotPW.classList.add("forgotUserOrPw");
    forgotPW.innerText = "Forgot username or password";
    loginForm.appendChild(forgotPW);

    const registerButton = document.createElement("button");
    registerButton.classList.add("registerButton");
    registerButton.innerText = "Register";
    loginSection.appendChild(registerButton);

    loginButton.addEventListener('click', () => {
        user = usernameInput.value;
        displayMyPage(user);
    });

    return mainSection;
}
const renderBackground = () => {
    const backgroundElement = document.querySelector(".home")
    backgroundElement.style.backgroundImage = "url('./images/mountain.gif')"
}

const displayHome = () => {
    renderBackground();
    const container = document.querySelector(".container");
    const mainSection = document.querySelector(".main");
    container.prepend(renderHeader());
    container.append(renderFooter());
    container.append(renderLogin());
}

export {
    displayHome
}