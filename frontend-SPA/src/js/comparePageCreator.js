import {
    createHamburgerBtn
} from './hamburger.js'

import {
    user
} from './app.js'

import {
    getCompareEventsByUserNameAndDay
} from './myCompareCalendarFetch.js'

const renderCompareHeader = ()=>{
    const headerElement = document.createElement("header");
    headerElement.classList.add("compare_header");
    headerElement.innerText = "Compare With Friends";
    return headerElement;
}

const renderMonthSection = () => {
    const compareContainer = document.createElement("div")
    compareContainer.classList.add("compareContainer");

    const monthSection = document.createElement("div");
    monthSection.classList.add("month_section");
    compareContainer.appendChild(monthSection);
    
    
    
    const leftArrow = document.createElement("img");
    leftArrow.classList.add("left_arrow");
    leftArrow.setAttribute('src', "./images/left-arrow.png");
    leftArrow.setAttribute('width', '100');
    leftArrow.setAttribute('height', '100');
    monthSection.appendChild(leftArrow);
 
    const currentMonth = document.createElement("div");
    currentMonth.classList.add("currentMonth");
    currentMonth.innerText = "Month";
    monthSection.appendChild(currentMonth);

    const rightArrow = document.createElement("img");
    rightArrow.classList.add("right_arrow");
    rightArrow.setAttribute('src', "./images/right-arrow.png");
    rightArrow.setAttribute('width', '100');
    rightArrow.setAttribute('height', '100');
    monthSection.appendChild(rightArrow);

    const calendarContainer = document.createElement("div");
    calendarContainer.classList.add("calendarContainer");
    

    const myCompareCalendar = document.createElement('div');
    myCompareCalendar.classList.add('my_CompareCalendar');
    // myCompareCalendar.innerHTML=`<object type="text/html" data="./comparePageCalendar.html" width="460" height="320" ></object> `;

    const myCalendar = document.createElement('div');
    myCalendar.classList.add('compareCalendarCell');

    myCompareCalendar.appendChild(myCalendar);

    const sun = document.createElement('div');
    sun.classList.add('sun')
    sun.innerText = "Sun"
    myCalendar.appendChild(sun);

    const mon = document.createElement('div');
    mon.classList.add('mon')
    mon.innerText = "Mon"
    myCalendar.appendChild(mon);

    const tue = document.createElement('div');
    tue.classList.add('tue')
    tue.innerText = "Tue"
    myCalendar.appendChild(tue);

    const wed = document.createElement('div');
    wed.classList.add('wed')
    wed.innerText = "Wed"
    myCalendar.appendChild(wed);

    const thur = document.createElement('div');
    thur.classList.add('thur')
    thur.innerText = "Thur"
    myCalendar.appendChild(thur);

    const fri = document.createElement('div');
    fri.classList.add('fri')
    fri.innerText = "Fri"
    myCalendar.appendChild(fri);

    const sat = document.createElement('div');
    sat.classList.add('sat')
    sat.innerText = "Sat"
    myCalendar.appendChild(sat);

    let cellNumber = 1;
    while (cellNumber <= 42){
        let cell = document.createElement('div');
        cell.classList.add(`cell${cellNumber}`);
        myCalendar.appendChild(cell);
        cellNumber++;
    }

    getCompareEventsByUserNameAndDay(user);


    calendarContainer.appendChild(myCompareCalendar);
    const myCalendarTitle = document.createElement("h3");
    myCalendarTitle.classList.add("myCalendarTitle");
    myCalendarTitle.innerText = "My Calendar";
    myCompareCalendar.prepend(myCalendarTitle);

    const friendsCompareCalendar = document.createElement('div');
    friendsCompareCalendar.classList.add('friends_CompareCalendar');
    // friendsCompareCalendar.innerHTML=`<object type="text/html" data="./friendscompareCalendar.html" width="460" height="320"></object> `;

    const friendCalendar = document.createElement('div');
    friendCalendar.classList.add('friendsCompareCalendarCell');

    friendsCompareCalendar.appendChild(friendCalendar);

    const mySun = document.createElement('div');
    mySun.classList.add('sun')
    mySun.innerText = "Sun"
    friendCalendar.appendChild(mySun);

    const myMon = document.createElement('div');
    myMon.classList.add('mon')
    myMon.innerText = "Mon"
    friendCalendar.appendChild(myMon);

    const myTue = document.createElement('div');
    myTue.classList.add('tue')
    myTue.innerText = "Tue"
    friendCalendar.appendChild(myTue);

    const myWed = document.createElement('div');
    myWed.classList.add('wed')
    myWed.innerText = "Wed"
    friendCalendar.appendChild(myWed);

    const myThur = document.createElement('div');
    myThur.classList.add('thur')
    myThur.innerText = "Thur"
    friendCalendar.appendChild(myThur);

    const myFri = document.createElement('div');
    myFri.classList.add('fri')
    myFri.innerText = "Fri"
    friendCalendar.appendChild(myFri);

    const mySat = document.createElement('div');
    mySat.classList.add('sat')
    mySat.innerText = "Sat"
    friendCalendar.appendChild(mySat);

    let myCellNumber = 1;
    while (myCellNumber <= 42){
        let myCell = document.createElement('div');
        myCell.classList.add(`friendCell${myCellNumber}`);
        friendCalendar.appendChild(myCell);
        myCellNumber++;
    }

    
    calendarContainer.appendChild(friendsCompareCalendar);
    const friendCalendarTitle = document.createElement("h3");
    friendCalendarTitle.classList.add("friendCalendarTitle");
    friendCalendarTitle.innerText = "Friend's Calendar";
    friendsCompareCalendar.prepend(friendCalendarTitle);

    compareContainer.appendChild(calendarContainer);
    compareContainer.appendChild(monthSection);
    
    return compareContainer;
}

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
    // container.append(renderCalendar());
}

export{
    displayComparePage
}