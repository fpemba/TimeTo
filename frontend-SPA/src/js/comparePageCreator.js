const renderCompareHeader = ()=>{
    const headerElement = document.createElement("header");
    headerElement.classList.add("compare_header");
    headerElement.innerText = "Compare With Friends";
    return headerElement;
}

const clearView = () => {
    const container = document.querySelector(".container")
    while (container.firstChild) {
        container.removeChild(container.firstChild);
    }
}

const displayComparePage = ()=>{
    clearView();
    const container = document.querySelector(".compare_container");
    container.append(renderCompareHeader());
}

export{displayComparePage}