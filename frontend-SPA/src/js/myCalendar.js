const renderMyHeader = ()=> {
    const headerElement = document.createElement("header");
    headerElement.classList.add("header");
    headerElement.innerText = "My Calendar";
    return headerElement;
}
const clearBackground = () => {
    const home = document.querySelector(".home");
    home.style.background = 'none';
}
const clearView = () => {
    // const body = document.querySelector("body")
    while (body.firstChild) {
        body.removeChild(body.firstChild);
    }
}
const renderBackground = ()=> {
    const backgroundElement = document.querySelector(".home")
    document.body.style.backgroundColor = "blue"
}
const displayMyPage = ()=> {
    clearView();
    clearBackground();
    renderBackground();
    const container = document.querySelector(".container");
    container.append(renderMyHeader());
}

export {
    displayMyPage
}