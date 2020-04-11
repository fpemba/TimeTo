const getEventsByUserNameAndDay = ()=> {
    return fetch('http://localhost:8080/months/stumax7April2020/')
        .then(response => response.json())
        .then(monthJson => renderDaysByMonth(monthJson))};
        
const renderDaysByMonth = (month) => {
        let monthLength = month.length;
        let currentDay = month.firstDayOfMonth;
        month.days.forEach(day => {
        let cell = document.querySelector(`.cell${currentDay}`);
        currentDay++;
        cell.innerText = day.dayNumber;
        cell.addEventListener('click', ()=>{
            const cellModal = document.createElement('div');
            cellModal.classList.add("cellModal");
            // let dayEventJSON = JSON.stringify(day.events);
            // cellModal.innerText = dayEventJSON;
            day.events.forEach(event =>{
                const eventsList = document.createElement('ul');
                cellModal.appendChild(eventsList)
                const eventsListItem = document.createElement('li');
                eventsListItem.innerText = event.name;
                eventsList.appendChild(eventsListItem);
            })
            const close = document.createElement("span");
            close.classList.add("close");
            close.innerHTML = "&times;";
            cellModal.appendChild(close);
            close.addEventListener('click',()=>{
                cellModal.style.display = "none";
            })
            const calendarCell = document.querySelector(".calendarCell");
            calendarCell.appendChild(cellModal);
            cellModal.style.display = "block";
        })
        });
        }
    // }


// const renderDays = (currentDay, day) => {
//     console.log("javascript is so good")
    // days.forEach(day=>{
        // console.log("no it isnt");
        // const cell3 = document.querySelector('.cell3');
        // const newDiv = document.createElement('div');
        // newDiv.innerText = day.dayNumber;
        // cell3.appendChild(newDiv);
        
    // })
    
// }

const calendarCell = document.querySelector('.calendarCell')
console.log(calendarCell);
getEventsByUserNameAndDay();

export{getEventsByUserNameAndDay}