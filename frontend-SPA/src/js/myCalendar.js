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

const hamburgerBtn = () => {
//     const nav = document.querySelector('nav');
//     nav.innerHTML = 
//     <div id= \'menuToggle'>

//     <input type='checkbox'/>

//     <span></span>
//     <span></span>
//     <span></span>

//     <ul id='menu'>
//       <a href="#">
//         <li>Invite</li>
//       </a>
//       <a href='./compare-page.html'>
//         <li>Compare</li>
//       </a>
//       <a href='./create-group.html'>
//         <li>Manage Groups</li>
//       </a>
//       <a href='#'>
//         <li>Import Calendar</li>
//       </a>
//       <a href='#'>
//         <li>View Friends</li>
//       </a>
//     </ul>
//   </div>

   
    // nav.setAttribute('input','checkbox')
    // document.createElement('span')
    // document.createElement('span')
    // document.createElement('span')
    // btnContainer.appendChild(nav);

    return nav;

    //need to add menu toggle class then append to nav
    // figure out how to use span to create lines


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
    container.append(renderMonth());
    container.appendChild(renderFooter());
    container.appendChild(renderMonthPicture());
    container.appendChild(hamburgerBtn());
}

export {
    displayMyPage
}
