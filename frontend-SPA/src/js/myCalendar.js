const renderMyHeader = () => {
    const headerElement = document.createElement("header");
    headerElement.classList.add("header");
    headerElement.innerText = "My Calendar";
    return headerElement;
}

const renderFooter = ()=>{
    const footerElement = document.createElement("footer");
    footerElement.classList.add("footer");
    footerElement.innerText = "© TimeTo 2020";
    return footerElement;
}

const renderMonth = ()=> {

    const mainHeader = document.createElement('main');
    mainHeader.classList.add("calendar_container");
    const monthHeader = document.createElement("div");
    monthHeader.classList.add("monthHeader")

    const leftArrow = document.createElement('img')
    leftArrow.setAttribute('src',"./images/left-arrow.png")
    leftArrow.setAttribute('width','100');
    monthHeader.appendChild(leftArrow);

    const monthElement = document.createElement("span");
    monthElement.classList.add("currentMonth");
    monthElement.innerText = "Month";
    monthHeader.appendChild(monthElement);
    mainHeader.appendChild(monthHeader);

    const rightArrow = document.createElement('img')
    rightArrow.setAttribute('src',"./images/right-arrow.png")
    rightArrow.setAttribute('width','100');
    monthHeader.appendChild(rightArrow);

    const monthPicture = document.createElement('img');
    monthPicture.classList.add('calendar');
    monthPicture.setAttribute('src','./images/index.png')
    monthPicture.setAttribute('width','600')
    monthPicture.setAttribute('height','400')
    monthPicture.setAttribute('a', 'href')
    mainHeader.appendChild(monthPicture);
    
    return mainHeader;
}

const createHamburgerBtn = () => {
    const nav = document.createElement("nav");
    const menuToggle = document.createElement("div");
    menuToggle.classList.add("menuToggle");
    nav.appendChild(menuToggle);
    const input = document.createElement("input");
    input.setAttribute('type','checkbox');
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

    const inviteLink = document.createElement("a");
    inviteLink.setAttribute('href', '#');
    navList.appendChild(inviteLink);
    const inviteText = document.createElement("li");
    inviteText.innerText = "Invite";
    inviteLink.appendChild(inviteText);

    const compareLink = document.createElement("a");
    compareLink.setAttribute('href', '#');
    compareLink.classList.add('compare_link')
    navList.appendChild(compareLink);
    const compareText = document.createElement("li");
    compareText.innerText = "Compare";
    compareLink.appendChild(compareText);

    const manageLink = document.createElement("a");
    manageLink.setAttribute('href', '#');
    navList.appendChild(manageLink);
    const manageText = document.createElement("li");
    manageText.innerText = "Manage Groups";
    manageLink.appendChild(manageText);

    const importLink = document.createElement("a");
    importLink.setAttribute('href', '#');
    navList.appendChild(importLink);
    const importText = document.createElement("li");
    importText.innerText = "Import Calendar";
    importLink.appendChild(importText);

    // return nav;

        // const navElement = document.createElement("nav");
        // navElement.classList.add("navigation");
        
        // const toggleSection = document.createElement("div");
        // toggleSection.classList.add("menuToggle");
        // navElement.appendChild(toggleSection);
        
        // const checkElement = document.createElement("input");
        // checkElement.setAttribute("checkbox")
        // toggleSection.appendChild(checkElement);
        
        // const spanOne = document.createElement("span");
        // toggleSection.appendChild(spanOne);
          
        // const spanTwo = document.createElement("span");
        // toggleSection.appendChild(spanTwo);
          
        // const spanThree = document.createElement("span");
        // toggleSection.appendChild(spanThree);
          
        // const burgerMenu = document.createElement("menu");
        // toggleSection.appendChild(burgerMenu);

        // return navElement;

    //     const nav = document.createElement("nav");
    //     nav.innerHTML = `<div class="menuToggle">

    //     <input type="checkbox" />

    //     <span></span>
    //     <span></span>
    //     <span></span>

    //     <ul class="menu">
    //       <a href="#">
    //         <li>Invite</li>
    //       </a>
    //       <a href="./compare-page.html">
    //         <li>Compare</li>
    //       </a>
    //       <a href="./create-group.html">
    //         <li>Manage Groups</li>
    //       </a>
    //       <a href="#">
    //         <li>Import Calendar</li>
    //       </a>
    //       <a href="#">
    //         <li>View Friends</li>
    //       </a>
    //     </ul>
    //   </div>`

          
      return nav;
        }

    //need to add menu toggle class then append to nav
    // figure out how to use span to create lines


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
    container.append(renderMonth());
    container.appendChild(renderFooter());
    // container.appendChild(renderMonthPicture());
    container.appendChild(createHamburgerBtn());
}

export {
    displayMyPage
}
