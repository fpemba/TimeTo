import {
    createHamburgerBtn
} from './hamburger.js'

const renderCompareHeader = ()=>{
    const headerElement = document.createElement("header");
    headerElement.classList.add("compare_header");
    headerElement.innerText = "Compare With Friends";
    return headerElement;
}

const renderMonthSection = () => {
    const monthSection = document.createElement("div");
    monthSection.classList.add("month_section");
    
    
    const leftArrow = document.createElement("img");
    leftArrow.classList.add("left_arrow");
    leftArrow.setAttribute('src', "./images/left-arrow.png");
    leftArrow.setAttribute('width', '100');
    leftArrow.setAttribute('height', '100');
    monthSection.appendChild(leftArrow);
    
    const currentMonth = document.createElement("h3");
    currentMonth.classList.add("currentMonth");
    currentMonth.innerText = "Month";
    monthSection.appendChild(currentMonth);
    
    const rightArrow = document.createElement("img");
    rightArrow.classList.add("right_arrow");
    rightArrow.setAttribute('src', "./images/right-arrow.png");
    rightArrow.setAttribute('width', '100');
    rightArrow.setAttribute('height', '100');
    monthSection.appendChild(rightArrow);

    
    const compareCalendar = document.createElement('div');
    compareCalendar.classList.add('myAndFriendCompareCalendar');
    currentMonth.appendChild(compareCalendar);
    // containerSection.appendChild(compareCalendar);

    const myCompareCalendar = document.createElement('div');
    myCompareCalendar.classList.add('my_CompareCalendar');
    myCompareCalendar.innerHTML=`<object type="text/html" data="./comparePageCalendar.html" width="300" height="300" ></object> `;
    compareCalendar.appendChild(myCompareCalendar);

    const friendsCompareCalendar = document.createElement('div');
    friendsCompareCalendar.classList.add('friends_CompareCalendar');
    friendsCompareCalendar.innerHTML=`<object type="text/html" data="./friendscompareCalendar.html" width="300" height="300" ></object> `;
    compareCalendar.appendChild(friendsCompareCalendar);
    
    return monthSection;
}

// const renderCalendar = () => {
    // const container = document.querySelector('container');
    // const compareCalendar = document.createElement('div');
    // compareCalendar.classList.add('myAndFriendCompareCalendar');
    // currentMonth.appendChild(compareCalendar);
    // container.appendChild(compareCalendar);

    // const myCompareCalendar = document.createElement('div');
    // myCompareCalendar.classList.add('my_CompareCalendar');
    // myCompareCalendar.innerHTML=`<object type="text/html" data="./comparePageCalendar.html" width="300" height="300" ></object> `;
    // compareCalendar.appendChild(myCompareCalendar);

    // const friendsCompareCalendar = document.createElement('div');
    // friendsCompareCalendar.classList.add('friends_CompareCalendar');
    // friendsCompareCalendar.innerHTML=`<object type="text/html" data="./friendscompareCalendar.html" width="300" height="300" ></object> `;
    // compareCalendar.appendChild(friendsCompareCalendar);

    // return renderCalendar;

// }

const renderFriendSection = ()=>{
    const friendsList = document.createElement("ul");
    friendsList.classList.add("friends-list");
    
    const friendsTitle = document.createElement("h3");
    friendsTitle.innerText = "Friends";
    friendsList.appendChild(friendsTitle);

    const friend1 = document.createElement("li");
    friend1.innerText = "Friend";
    friendsList.appendChild(friend1);
    const friend2 = document.createElement("li");
    friend2.innerText = "Friend";
    friendsList.appendChild(friend2);
    const friend3 = document.createElement("li");
    friend3.innerText = "Friend";
    friendsList.appendChild(friend3);
    const friend4 = document.createElement("li");
    friend4.innerText = "Friend";
    friendsList.appendChild(friend4);
    const friend5 = document.createElement("li");
    friend5.innerText = "Friend";
    friendsList.appendChild(friend5);
    const friend6 = document.createElement("li");
    friend6.innerText = "Friend";
    friendsList.appendChild(friend6);
    const friend7 = document.createElement("li");
    friend7.innerText = "Friend";
    friendsList.appendChild(friend7);
    const friend8 = document.createElement("li");
    friend8.innerText = "Friend";
    friendsList.appendChild(friend8);

    return friendsList;
}

const renderFooter = () => {
    const footerElement = document.createElement("footer");
    footerElement.classList.add("footer");
    footerElement.innerText = "© TimeTo 2020";
    return footerElement;
}

const clearView = () => {
    const container = document.querySelector(".container")
    while (container.firstChild) {
        container.removeChild(container.firstChild);
    }
}

const displayComparePage = ()=>{
    clearView();
    const container = document.querySelector(".container");
    container.append(renderCompareHeader());
    container.append(createHamburgerBtn());
    container.append(renderMonthSection());
    container.append(renderFriendSection());
    container.append(renderFooter());
    container.append(renderCalendar());
}

export{
    displayComparePage
}