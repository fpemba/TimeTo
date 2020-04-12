import {
    createHamburgerBtn
} from './hamburger.js'

// import{
//     getEventsByUserNameAndDay
// }from './myCalendarFetch.js'

const renderMyHeader = () => {
    const headerElement = document.createElement("header");
    headerElement.classList.add("header");
    headerElement.innerText = "My Calendar";
    return headerElement;
}

const renderFooter = () => {
    const footerElement = document.createElement("footer");
    footerElement.classList.add("footer");
    footerElement.innerText = "© TimeTo 2020";
    return footerElement;
}

const getMonth = ()=> {
    return fetch("http://localhost:8080/months/stumax7April2020/")
        .then(response => response.json())
        .then(monthJson => renderMonth(monthJson))
} 

const renderMonth = (month) => {

    const mainHeader = document.createElement('main');
    mainHeader.classList.add("calendar_container");
    const monthHeader = document.createElement("div");
    monthHeader.classList.add("monthHeader")

    const leftArrow = document.createElement('img')
    leftArrow.setAttribute('src', "./images/left-arrow.png")
    leftArrow.setAttribute('width', '100');
    monthHeader.appendChild(leftArrow);

    const monthElement = document.createElement("h3");
    monthElement.classList.add("currentMonth");
    monthElement.innerText = month.name;
    monthHeader.appendChild(monthElement);
    mainHeader.appendChild(monthHeader);

    const rightArrow = document.createElement('img')
    rightArrow.setAttribute('src', "./images/right-arrow.png")
    rightArrow.setAttribute('width', '100');
    monthHeader.appendChild(rightArrow);

    const myCalendar = document.createElement('div');
    myCalendar.classList.add('my_calendar');

    myCalendar.innerHTML=`<object type="text/html" data="./calendar.html" width="700" height="400" ></object> `;

   
    mainHeader.appendChild(myCalendar);


    return mainHeader;
}


    

const clearBackground = () => {
    const home = document.querySelector('.home');
    home.style.backgroundImage = "";
}
const clearView = () => {
    const container = document.querySelector(".container")
    while (container.firstChild) {
        container.removeChild(container.firstChild);
    }
}


const displayMyPage = () => {
    clearView();
    const container = document.querySelector(".container");
    clearBackground();
    container.appendChild(renderMyHeader());
    // container.append(getMonth());
    getMonth().then(element => container.append(element));
    // container.appendChild(renderMonth());
    container.appendChild(renderFooter());
    container.appendChild(createHamburgerBtn());
    // getEventsByUserNameAndDay().then(element => container.append(element));
 
   
}



export {
    displayMyPage
}