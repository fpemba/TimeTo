import {
    createHamburgerBtn
} from './hamburger.js'

const renderMyGroupHeader = () => {
    const groupHeaderElement = document.createElement("header");
    groupHeaderElement.classList.add("header");
    groupHeaderElement.innerText = "Manage Groups";
    return groupHeaderElement;
}

const renderFooter = () => {
    const footerElement = document.createElement("footer");
    footerElement.classList.add("footer");
    footerElement.innerText = "© TimeTo 2020";
    return footerElement;
}

const renderMyGroups = () => {
    const container = document.createElement('div')
    container.classList.add('group-container')
    const myGroups = document.createElement('section');
    container.appendChild(myGroups);
    myGroups.classList.add('current-groups-body');
    const groupBtn = document.createElement('button');
    groupBtn.textContent = 'Create New Group';
    myGroups.appendChild(groupBtn);

    const currentGroups = document.createElement('h3');
    currentGroups.classList.add('group-titles');
    currentGroups.textContent = 'Current Groups'
    myGroups.appendChild(currentGroups);

    const groupSchedule = document.createElement('h3');
    groupSchedule.classList.add('group-schedule');
    groupSchedule.textContent = 'Group Schedule'
    container.appendChild(groupSchedule);

    return container;

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

const displayMyGroupPage = () => {
    clearView();
    const container = document.querySelector(".container");
    clearBackground();
    container.appendChild(renderMyGroupHeader());
    container.append(renderFooter());
    container.appendChild(renderMyGroups());
    container.appendChild(createHamburgerBtn());

   
}



export {
    displayMyGroupPage
}