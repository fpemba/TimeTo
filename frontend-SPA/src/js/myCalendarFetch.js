const getEventsByUserNameAndDay = ()=> {
    return fetch('http://localhost:8080/days/')
        .then(response => response.json())
        .then(dayJson => renderDays(dayJson));
        
}

const renderDays = (days) => {
    console.log("javascript is so good")
    // days.forEach(day=>{
    //     console.log("no it isnt");
    //     const cell3 = document.querySelector('.cell3');
    //     const newDiv = document.createElement('div');
    //     newDiv.innerText = day.dayNumber;
    //     cell3.appendChild(newDiv);
        
    // })
    
}

const calendarCell = document.querySelector('.calendarCell')
// renderDays().then(element => calendarCell.append(element));
console.log("This works");

export{getEventsByUserNameAndDay}