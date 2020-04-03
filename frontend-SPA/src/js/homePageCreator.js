// class HomePageCreator{

//     constructor(){
//     this._main = document.createElement("main");
//     this._header = document.createElement("header");
//     this._span = document.createElement("span");
//     this._login = document.createElement("p");
//     this._form = document.createElement("form");
//     this._forgotPW = document.createElement("a");
//     this._submitButton = document.createElement("button");
//     this._footer = document.createElement("footer");
//     }

//     render(){
//         this._container.className = 'homePage';
//         this._container.append(this._main);
//         this._container.append(this._header);
//         this._container.append(this._span);
//         this._container.append(this._login);
//         this._container.append(this._form);
//         this._container.append(this._forgotPW);
//         this._container.append(this._submitButton);
//         this._footer.append(this._footer);
//         return this._container;
//     }
// }

const renderHeader = ()=> {
    const headerElement = document.createElement("header");
    headerElement.classList.add("header");
    headerElement.innerText = "TimeTo";
    return headerElement;
}

const renderFooter = ()=>{
    const footerElement = document.createElement("footer");
    footerElement.classList.add("footer");
    footerElement.innerText = "© TimeTo 2020";
    return footerElement;
}

const renderLogin = ()=>{
    const mainSection = document.createElement("main");
    mainSection.classList.add("main");

    const loginSection = document.createElement("section");
    loginSection.classList.add("login");
    mainSection.appendChild(loginSection);

    const signIn = document.createElement("p");
    signIn.classList.add("signIn");
    loginSection.appendChild(signIn);
    signIn.innerText = "Sign In!"
    return mainSection;

    // const loginForm = document.createElement("form");
    // loginForm.classList.add("loginForm");

    // const forgotPW = document.createElement("a");
    // forgotPW.classList.add("forgotPW");

    // const loginButton = document.createElement("button");
    // loginButton.classList.add("loginButton");
    // loginForm.appendChild(loginButton);

    // const registerButton = document.createElement("button");
    // registerButton.classList.add("registerButton");

}

const displayHome = () =>{
    const container = document.querySelector(".container");
    const mainSection = document.querySelector(".main");
    container.prepend(renderHeader());
    container.append(renderFooter());
    container.append(renderLogin());
}

export{
    displayHome}