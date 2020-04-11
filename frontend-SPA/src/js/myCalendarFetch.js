const getEventsByUserNameAndDay = ()=> {
    return fetch('http://localhost:8080/months/stumax7April2020/')
        .then(response => response.json())
        .then(monthJson => renderDaysByMonth(monthJson))};
        
const renderDaysByMonth = (month) => {
        let monthLength = month.length;
        console.log(month);
        let currentDay = month.firstDayOfMonth;
        console.log(month.days);
        month.days.forEach(day => {
        let cell = document.querySelector(`.cell${currentDay}`);
        currentDay++;
        cell.innerText = day.dayNumber;
        cell.addEventListener('click', ()=>{
            const cellModal = document.createElement('div');
            cellModal.classList.add("cellModal");
            cellModal.innerText = "I'm a modal!";
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