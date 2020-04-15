
import {
    displayComparePage
} from './comparePageCreator.js';

import {displayMyPage} from './myCalendar.js';

import {
    displayMyGroupPage
} from './manage-group.js'

import {
    user
} from './app.js'

const createHamburgerBtn = () => {
    const nav = document.createElement("nav");
    const menuToggle = document.createElement("div");
    menuToggle.classList.add("menuToggle");
    nav.appendChild(menuToggle);
    const input = document.createElement("input");
    input.setAttribute('type', 'checkbox');
    menuToggle.appendChild(input);

    const span1 = document.createElement('span')
    // burger.innerText = "&#9776;";
    const span2 = document.createElement('span')
    const span3 = document.createElement('span')
    menuToggle.appendChild(span1);
    menuToggle.appendChild(span2);
    menuToggle.appendChild(span3);

    const navList = document.createElement("ul");
    navList.classList.add("menu");
    menuToggle.appendChild(navList);

    const myCalendarLink = document.createElement("a");
    myCalendarLink.setAttribute('href', '#');
    navList.appendChild(myCalendarLink);
    const myCalendarText = document.createElement("li");
    myCalendarText.innerText = "My Calendar";
    myCalendarLink.appendChild(myCalendarText);
    myCalendarLink.addEventListener('click', (event) => {
        event.preventDefault();
        displayMyPage(user);
    })

    // const inviteLink = document.createElement("a");
    // inviteLink.setAttribute('href', '#');
    // navList.appendChild(inviteLink);
    // const inviteText = document.createElement("li");
    // inviteText.innerText = "Invite";
    // inviteLink.appendChild(inviteText);

    const compareLink = document.createElement("a");
    compareLink.setAttribute('href', '#');
    compareLink.classList.add('compare_link')
    navList.appendChild(compareLink);
    const compareText = document.createElement("li");
    compareText.innerText = "Compare";
    compareLink.appendChild(compareText);
    compareLink.addEventListener('click', (event) => {
        event.preventDefault()
        displayComparePage()
    });

    // const manageLink = document.createElement("a");
    // manageLink.setAttribute('href', '#');
    // navList.appendChild(manageLink);
    // const manageText = document.createElement("li");
    // manageText.innerText = "Manage Groups";
    // manageLink.appendChild(manageText);
    // manageLink.addEventListener('click', (event) => {
    //     event.preventDefault()
    //     displayMyGroupPage()
    // });

    // const importLink = document.createElement("a");
    // importLink.setAttribute('href', '#');
    // navList.appendChild(importLink);
    // const importText = document.createElement("li");
    // importText.innerText = "Import Calendar";
    // importLink.appendChild(importText);

    return nav;
}

export {
    createHamburgerBtn
}