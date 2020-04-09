const getEventsByUserNameAndDay = ()=> {
    return fetch('http://localhost:8080/months/5/')
        .then(response => response.json)
        .then(monthJson => getMonthInfo(monthJson));
    // return fetch('http://localhost:8080/days/Praetor-04-08-2020')
    //     .then(response => response.json())
    //     .then(dayJson => renderDays(dayJson));
    // console.log("ZERO")   
}

const getMonthInfo = (month) => {
    let monthLength = month.length;
    let currentDay = month.firstDayOfMonth;
    // for(i = 0; i <= monthLength; i++){
        fetch(`http://localhost:8080/days/Praetor-04-08-2020/`)
        .then(response => response.json())
        .then(dayJson => renderDays(currentDay, dayJson));
        console.log("ONE");

    // }
}

const renderDays = (currentDay, day) => {
    console.log("javascript is so good")
    // days.forEach(day=>{
        console.log("no it isnt");
        // const cell3 = document.querySelector('.cell3');
        // const newDiv = document.createElement('div');
        // newDiv.innerText = day.dayNumber;
        // cell3.appendChild(newDiv);
        console.log(currentDay)
        console.log(day)
        const cell = document.querySelector(`.cell${day.dayNumber}`);
        cell.innerText = day.id;
        console.log("TWO");
    // })
    
}

const calendarCell = document.querySelector('.calendarCell')
console.log(calendarCell);
getEventsByUserNameAndDay().then(element => calendarCell.append(element));
console.log("This works");

export{getEventsByUserNameAndDay}