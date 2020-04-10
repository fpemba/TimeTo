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
            cell.appendChild(cellModal);
            const modalPopUp = document.createElement('div');
            modalPopUp.classList.add("modalPopUp");
            cellModal.appendChild(modalPopUp);
            const close = document.createElement("span");
            close.classList.add("close");
            cellModal.appendChild(close);
            const modalContent = document.createElement("div");
            modalContent.classList.add("modalContent");
            cellModal.appendChild(modalContent);
            const calendarCell = document.querySelector(".calendarCell");
            calendarCell.appendChild(cellModal);
            cellModal.style.display = "block";
            console.log("is this even working")
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